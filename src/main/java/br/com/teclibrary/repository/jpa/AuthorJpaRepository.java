package br.com.teclibrary.repository.jpa;

import br.com.teclibrary.domain.AuthorEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorJpaRepository implements PanacheRepository<AuthorEntity> {
}
