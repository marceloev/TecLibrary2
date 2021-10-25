package br.com.teclibrary.repository.jpa;

import br.com.teclibrary.domain.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserJpaRepository implements PanacheRepository<UserEntity> {

    public UserEntity findByEmail(final String email) {
        return find("email", email).firstResult();
    }

    public Long countByEmail(final String email) {
        return count("email", email);
    }

    public UserEntity findByActivation(final String activation) {
        return find("activation", activation).firstResult();
    }

    public UserEntity findByEmailAndActivation(final String email, final String activation) {
        return find("email = ?1 and activation = ?2", email, activation).firstResult();
    }
}
