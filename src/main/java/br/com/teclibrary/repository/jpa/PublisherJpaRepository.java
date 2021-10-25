package br.com.teclibrary.repository.jpa;

import br.com.teclibrary.domain.PublisherEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PublisherJpaRepository implements PanacheRepository<PublisherEntity> {
}
