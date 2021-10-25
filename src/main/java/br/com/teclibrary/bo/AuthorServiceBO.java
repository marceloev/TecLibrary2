package br.com.teclibrary.bo;

import br.com.teclibrary.model.data.Author;
import br.com.teclibrary.model.request.AuthorInsertRequest;
import br.com.teclibrary.model.request.AuthorUpdateRequest;
import br.com.teclibrary.repository.AuthorRepository;
import io.quarkus.panache.common.Page;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class AuthorServiceBO {

    @Inject
    AuthorRepository authorRepository;

    public List<Author> findAll(final Page page) {
        return authorRepository.findAll(page);
    }

    @Transactional
    public Author insert(final AuthorInsertRequest request) {
        Author author = new Author(request);
        return authorRepository.insert(author);
    }

    @Transactional
    public Author update(final AuthorUpdateRequest request) {
        Author author = authorRepository.findById(request.getId());
        author.update(request);
        return authorRepository.update(author);
    }

    @Transactional
    public void delete(final Long id) {
        authorRepository.delete(id);
    }
}
