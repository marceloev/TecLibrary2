package br.com.teclibrary.repository.jpa;

import br.com.teclibrary.domain.BookEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BookJpaRepository implements PanacheRepository<BookEntity> {

    public List<BookEntity> findByAuthorId(final Long id) {
        return list("author.id", id);
    }
}
