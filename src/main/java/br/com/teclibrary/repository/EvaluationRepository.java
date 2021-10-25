package br.com.teclibrary.repository;

import br.com.teclibrary.model.data.Evaluation;
import io.quarkus.panache.common.Page;

import java.util.List;

public interface EvaluationRepository {
    Evaluation findById(Long id);
    List<Evaluation> findByUserId(Long userId);
    List<Evaluation> findAll(Page page);
    Evaluation insert(Evaluation evaluation);
}
