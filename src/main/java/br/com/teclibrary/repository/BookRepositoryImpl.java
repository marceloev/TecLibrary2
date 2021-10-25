package br.com.teclibrary.repository;

import br.com.teclibrary.domain.BookEntity;
import br.com.teclibrary.model.data.Book;
import br.com.teclibrary.model.mapper.BookMapper;
import br.com.teclibrary.repository.jpa.BookJpaRepository;
import io.quarkus.panache.common.Page;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class BookRepositoryImpl implements BookRepository {

    @Inject
    BookJpaRepository bookJpaRepository;

    @Override
    public Book findById(final Long id) {
        return BookMapper.MAPPER.fromEntity(bookJpaRepository.findById(id));
    }

    @Override
    public List<Book> findAll(final Page page) {
        return BookMapper.MAPPER.fromEntity(bookJpaRepository.listAll());
    }

    @Override
    public List<Book> findByAuthorId(final Long id) {
        return BookMapper.MAPPER.fromEntity(bookJpaRepository.findByAuthorId(id));
    }

    @Override
    public Book insert(final Book book) {
        BookEntity bookEntity = BookMapper.MAPPER.toEntity(book);
        bookJpaRepository.persistAndFlush(bookEntity);
        return BookMapper.MAPPER.fromEntity(bookEntity);
    }

    @Override
    public Book save(final Book book) {
        BookEntity bookEntity = BookMapper.MAPPER.toEntity(book);
        bookJpaRepository.persistAndFlush(bookEntity);
        return BookMapper.MAPPER.fromEntity(bookEntity);
    }

    @Override
    public void delete(final Long id) {
        bookJpaRepository.deleteById(id);
    }
}
