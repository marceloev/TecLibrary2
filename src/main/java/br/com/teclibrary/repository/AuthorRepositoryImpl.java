package br.com.teclibrary.repository;

import br.com.teclibrary.domain.AuthorEntity;
import br.com.teclibrary.model.data.Author;
import br.com.teclibrary.model.mapper.AuthorMapper;
import br.com.teclibrary.repository.jpa.AuthorJpaRepository;
import io.quarkus.panache.common.Page;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class AuthorRepositoryImpl implements AuthorRepository {

    @Inject
    AuthorJpaRepository authorJpaRepository;

    @Override
    public Author findById(final Long id) {
        return AuthorMapper.MAPPER.fromEntity(authorJpaRepository.findById(id));
    }

    @Override
    public List<Author> findAll(final Page page) {
        return AuthorMapper.MAPPER.fromEntity(authorJpaRepository.listAll());
    }

    @Override
    public Author insert(final Author author) {
        AuthorEntity entity = AuthorMapper.MAPPER.toEntity(author);
        authorJpaRepository.persistAndFlush(entity);
        return AuthorMapper.MAPPER.fromEntity(entity);
    }

    @Override
    public Author update(final Author author) {
        AuthorEntity entity = AuthorMapper.MAPPER.toEntity(author);
        authorJpaRepository.persistAndFlush(entity);
        return AuthorMapper.MAPPER.fromEntity(entity);
    }

    @Override
    public void delete(final Long id) {
        authorJpaRepository.deleteById(id);
    }
}
