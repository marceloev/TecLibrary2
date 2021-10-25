package br.com.teclibrary.repository;

import br.com.teclibrary.model.data.Author;
import io.quarkus.panache.common.Page;

import java.util.List;

public interface AuthorRepository {
    Author findById(Long id);
    List<Author> findAll(Page page);
    Author insert(Author author);
    Author update(Author author);
    void delete(Long id);
}
