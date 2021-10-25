package br.com.teclibrary.handler.authentication;

import br.com.teclibrary.handler.util.JsonUtils;
import br.com.teclibrary.model.data.User;
import br.com.teclibrary.model.data.enums.TokenClaim;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.Instant;
import java.util.Base64;

@Dependent
public class JWTAuthenticationHandler implements AuthenticationHandler {

    private static final int MAX_BYTE_INDEX = 4096;

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;

    @ConfigProperty(name = "teclibrary.jwt.expiration")
    Long authExpiration;

    @ConfigProperty(name = "teclibrary.jwt.privatekey.location")
    String privateKeyLocation;

    @Inject
    JsonWebToken jsonWebToken;

    @Override
    public User getCurrentUser() {
        String user = jsonWebToken.getClaim(TokenClaim.USER.name());
        return JsonUtils.toObject(user, User.class);
    }

    @Override
    public String authenticate(final User user) {
        JwtClaimsBuilder claimsBuilder = Jwt.claims();
        claimsBuilder.issuer(issuer);
        claimsBuilder.subject(user.getEmail());
        claimsBuilder.issuedAt(Instant.now());
        claimsBuilder.expiresAt(Instant.now().plusSeconds(authExpiration));
        claimsBuilder.claim(TokenClaim.USER.name(), JsonUtils.toJSON(user));
        claimsBuilder.groups(this.getRoleHierarchy(user.getRole()));

        return claimsBuilder.jws().sign(retrievePrivateKey());
    }

    private PrivateKey retrievePrivateKey() {
        try (InputStream contentIS = this.getClass().getClassLoader().getResourceAsStream(privateKeyLocation)) {
            byte[] tmp = new byte[MAX_BYTE_INDEX];
            int length = contentIS.read(tmp);
            return decodePrivateKey(new String(tmp, 0, length, StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private PrivateKey decodePrivateKey(final String pemEncoded) throws Exception {
        byte[] encodedBytes = toEncodedBytes(pemEncoded);

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(keySpec);
    }

    private byte[] toEncodedBytes(final String pemEncoded) {
        String pem = pemEncoded.replaceAll("-----BEGIN (.*)-----", "");
        pem = pem.replaceAll("-----END (.*)----", "");
        pem = pem.replaceAll("\r\n", "");
        pem = pem.replaceAll("\n", "");
        final String normalizedPem = pem.trim();

        return Base64.getDecoder().decode(normalizedPem);
    }
}
