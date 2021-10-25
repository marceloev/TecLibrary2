package br.com.teclibrary.bo;

import br.com.teclibrary.handler.authentication.AuthenticationHandler;
import br.com.teclibrary.handler.mail.MailHandler;
import br.com.teclibrary.model.data.Identification;
import br.com.teclibrary.model.data.User;
import br.com.teclibrary.model.data.enums.AppIdentifier;
import br.com.teclibrary.model.data.enums.UserStatus;
import br.com.teclibrary.model.exception.BusinessException;
import br.com.teclibrary.model.exception.error.IdentificationBusinessError;
import br.com.teclibrary.model.exception.error.UserBusinessError;
import br.com.teclibrary.model.mail.RecoverUserMail;
import br.com.teclibrary.model.mail.WelcomeUserMail;
import br.com.teclibrary.model.request.IdentificationUpdateRequest;
import br.com.teclibrary.model.request.UserAuthenticationRequest;
import br.com.teclibrary.model.request.UserInsertRequest;
import br.com.teclibrary.model.request.IdentificationRecoverRequest;
import br.com.teclibrary.model.response.UserAuthenticationResponse;
import br.com.teclibrary.repository.IdentificationRepository;
import br.com.teclibrary.repository.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class AuthenticationServiceBO {

    @Inject
    UserRepository userRepository;

    @Inject
    IdentificationRepository identificationRepository;

    @Inject
    AuthenticationHandler authenticationHandler;

    @Inject
    MailHandler mailHandler;

    @Transactional
    public User register(final UserInsertRequest request) {
        Long existingUserCount = userRepository.countByEmail(request.getEmail());
        if (existingUserCount > 0) {
            throw new BusinessException(UserBusinessError.USER_ALREADY_EXISTS, request.getEmail());
        }

        User user = userRepository.insert(new User(request));
        identificationRepository.insert(new Identification(user.getId(), request));
        mailHandler.send(new WelcomeUserMail(user));
        return user;
    }

    public UserAuthenticationResponse authenticate(final UserAuthenticationRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            throw new BusinessException(IdentificationBusinessError.AUTHENTICATION_NOT_FOUND, request.getEmail());
        }

        if (UserStatus.PENDING.equals(user.getStatus())) {
            throw new BusinessException(IdentificationBusinessError.AUTHENTICATION_PENDING, request.getEmail());
        } else if (UserStatus.BLOCKED.equals(user.getStatus())) {
            throw new BusinessException(IdentificationBusinessError.AUTHENTICATION_BLOCKED);
        }

        Identification identification = identificationRepository.findByUserIdAndAppIdentifier(user.getId(), AppIdentifier.TECLIBRARY);
        if (!BcryptUtil.matches(identification.getPassword(), request.getPassword())) {
            throw new BusinessException(IdentificationBusinessError.AUTHENTICATION_FAILURE);
        }

        return UserAuthenticationResponse.builder()
                .userId(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .token((String) authenticationHandler.authenticate(user))
                .build();
    }

    @Transactional
    public User activateUser(final String activation) {
        User user = userRepository.findByActivation(activation);
        if (!List.of(UserStatus.PENDING, UserStatus.AUTHORIZED).contains(user.getStatus())) {
            throw new BusinessException(IdentificationBusinessError.USER_CANNOT_BE_ACTIVATED);
        }

        user.setStatus(UserStatus.AUTHORIZED);
        return userRepository.update(user);
    }

    public User updateIdentification(final IdentificationUpdateRequest request) {
        User user = userRepository.findByEmailAndActivation(request.getEmail(), request.getActivation());
        if (user == null) {
            throw new BusinessException(IdentificationBusinessError.AUTHENTICATION_NOT_FOUND, request.getEmail());
        }

        Identification identification = identificationRepository.findByUserIdAndAppIdentifier(user.getId(), AppIdentifier.TECLIBRARY);
        identification.update(request);
        identificationRepository.update(identification);
        return user;
    }

    public void requestRecoverPassword(final IdentificationRecoverRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            throw new BusinessException(IdentificationBusinessError.AUTHENTICATION_NOT_FOUND, request.getEmail());
        }

        mailHandler.send(new RecoverUserMail(user));
    }
}
