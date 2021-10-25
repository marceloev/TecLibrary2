package br.com.teclibrary.repository;

import br.com.teclibrary.model.data.Book;
import io.quarkus.panache.common.Page;

import java.util.List;

public interface BookRepository {

    Book findById(Long id);
    List<Book> findAll(Page page);
    List<Book> findByAuthorId(Long id);
    Book insert(Book book);
    Book save(Book book);
    void delete(Long id);

}
