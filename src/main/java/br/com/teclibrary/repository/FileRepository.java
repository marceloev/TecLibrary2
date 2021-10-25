package br.com.teclibrary.repository;

import br.com.teclibrary.model.data.File;
import io.quarkus.panache.common.Page;

import java.util.List;

public interface FileRepository {
    List<File> findAll(Page page);
    File findById(Long id);
    File insert(File file);
    File update(File file);
    void delete(Long id);
}
