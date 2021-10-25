package br.com.teclibrary.repository.jpa;

import br.com.teclibrary.domain.FileEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FileJpaRepository implements PanacheRepository<FileEntity> {
}
