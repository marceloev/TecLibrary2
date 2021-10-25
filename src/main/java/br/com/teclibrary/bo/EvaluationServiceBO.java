package br.com.teclibrary.bo;

import br.com.teclibrary.model.data.Book;
import br.com.teclibrary.model.data.Evaluation;
import br.com.teclibrary.model.data.User;
import br.com.teclibrary.model.request.EvaluationInsertRequest;
import br.com.teclibrary.repository.EvaluationRepository;
import io.quarkus.panache.common.Page;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class EvaluationServiceBO {

    @Inject
    EvaluationRepository evaluationRepository;

    @Inject
    BookServiceBO bookServiceBO;

    public Evaluation findById(final Long id) {
        return evaluationRepository.findById(id);
    }

    public List<Evaluation> findByUserId(final Long userId) {
        return evaluationRepository.findByUserId(userId);
    }

    public List<Evaluation> findAll() {
        return evaluationRepository.findAll(Page.of(0, 25));
    }

    @Transactional
    public Evaluation insert(final User user, final EvaluationInsertRequest request) {
        Book book = bookServiceBO.findById(request.getBookId());
        Evaluation evaluation = evaluationRepository.insert(new Evaluation(request, book, user));
        return evaluation;
    }
}
