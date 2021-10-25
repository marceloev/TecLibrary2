package br.com.teclibrary.repository;

import br.com.teclibrary.model.data.Gender;
import io.quarkus.panache.common.Page;

import java.util.List;

public interface GenderRepository {
    Gender findById(Long id);

    Gender insert(Gender gender);

    Gender update(Gender gender);

    List<Gender> findAll(Page page);

    void delete(Long id);
}
