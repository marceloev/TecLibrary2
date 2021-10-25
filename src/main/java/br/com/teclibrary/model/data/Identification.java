package br.com.teclibrary.model.data;

import br.com.teclibrary.model.data.enums.AppIdentifier;
import br.com.teclibrary.model.request.IdentificationUpdateRequest;
import br.com.teclibrary.model.request.UserInsertRequest;
import io.quarkus.elytron.security.common.BcryptUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Identification {
    private Long userId;
    private AppIdentifier appIdentifier;
    private String password;

    public Identification(final Long userId, final UserInsertRequest request) {
        this.userId = userId;
        this.appIdentifier = request.getAppIdentifier();
        this.password = BcryptUtil.bcryptHash(request.getPassword());
    }

    public void update(final IdentificationUpdateRequest request) {
        this.password = BcryptUtil.bcryptHash(request.getPassword());
    }
}
