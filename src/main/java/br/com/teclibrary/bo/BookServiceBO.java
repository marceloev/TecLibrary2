package br.com.teclibrary.bo;

import br.com.teclibrary.handler.util.Base64Utils;
import br.com.teclibrary.model.data.Book;
import br.com.teclibrary.model.request.BookInsertRequest;
import br.com.teclibrary.model.request.BookUpdateRequest;
import br.com.teclibrary.model.request.FileInsertRequest;
import br.com.teclibrary.model.response.FileUnwrapResponse;
import br.com.teclibrary.repository.BookRepository;
import io.quarkus.panache.common.Page;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Singleton
public class BookServiceBO {

    @Inject
    BookRepository bookRepository;

    @Inject
    FileServiceBO fileServiceBO;

    public List<Book> findAll() {
        return bookRepository.findAll(Page.of(0, 25));
    }

    public Book findById(final Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> findSuggestion(final Long id) { //TODO: Add A.I to get better suggestions.
        Book book = bookRepository.findById(id);

        return bookRepository.findByAuthorId(book.getAuthor().getId()).stream()
                .filter(b -> !b.getId().equals(book.getId()))
                .collect(Collectors.toList());
    }

    @Transactional
    public Book insert(final BookInsertRequest request) {
        Book book = new Book(request);
        persistBookFiles(book, request.getBase64Image(), request.getBase64File());
        return bookRepository.insert(book);
    }

    @Transactional
    public Book save(final BookUpdateRequest request) {
        Book book = bookRepository.findById(request.getId());
        book.update(request);
        persistBookFiles(book, request.getBase64Image(), request.getBase64File());
        return bookRepository.save(book);
    }

    private void persistBookFiles(final Book book, final String base64Image, final String base64File) {
        if (Objects.nonNull(base64Image)) {
            FileUnwrapResponse imageUnwrapResponse = Base64Utils.unwrap(base64Image);
            FileInsertRequest imageInsertRequest = new FileInsertRequest(imageUnwrapResponse.getContent(), book.getName(), imageUnwrapResponse.getFileType());
            book.setImage(fileServiceBO.insert(imageInsertRequest));
        }

        if (Objects.nonNull(base64File)) {
            FileUnwrapResponse fileUnwrapResponse = Base64Utils.unwrap(base64File);
            FileInsertRequest fileInsertRequest = new FileInsertRequest(fileUnwrapResponse.getContent(), book.getName(), fileUnwrapResponse.getFileType());
            book.setFile(fileServiceBO.insert(fileInsertRequest));
        }
    }

    @Transactional
    public void delete(final Long id) {
        bookRepository.delete(id);
    }
}
