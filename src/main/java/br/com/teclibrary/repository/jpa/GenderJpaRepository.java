package br.com.teclibrary.repository.jpa;

import br.com.teclibrary.domain.GenderEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GenderJpaRepository implements PanacheRepository<GenderEntity> {
}
