package br.com.teclibrary.repository;

import br.com.teclibrary.model.data.Publisher;
import io.quarkus.panache.common.Page;

import java.util.List;

public interface PublisherRepository {
    Publisher findById(Long id);
    List<Publisher> findAll(Page page);
    Publisher insert(Publisher publisher);
    Publisher update(Publisher publisher);
    void delete(Long id);
}
