package br.com.teclibrary.repository.jpa;

import br.com.teclibrary.domain.IdentificationEntity;
import br.com.teclibrary.model.data.enums.AppIdentifier;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IdentificationJpaRepository implements PanacheRepository<IdentificationEntity> {

    public IdentificationEntity findByUserIdAndAppIdentifier(final Long userId, final AppIdentifier appIdentifier) {
        return find("userId = ?1 and appIdentifier = ?2", userId, appIdentifier).firstResult();
    }
}
