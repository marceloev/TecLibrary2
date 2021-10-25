package br.com.teclibrary.repository;

import br.com.teclibrary.domain.EvaluationEntity;
import br.com.teclibrary.model.data.Evaluation;
import br.com.teclibrary.model.mapper.EvaluationMapper;
import br.com.teclibrary.repository.jpa.EvaluationJpaRepository;
import io.quarkus.panache.common.Page;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class EvaluationRepositoryImpl implements EvaluationRepository {

    @Inject
    EvaluationJpaRepository evaluationJpaRepository;

    @Override
    public Evaluation findById(final Long id) {
        return EvaluationMapper.MAPPER.fromEntity(evaluationJpaRepository.findById(id));
    }

    @Override
    public List<Evaluation> findByUserId(Long userId) {
        List<EvaluationEntity> evaluationEntities = evaluationJpaRepository.list("user.id", userId);
        return EvaluationMapper.MAPPER.fromEntity(evaluationEntities);
    }

    @Override
    public List<Evaluation> findAll(final Page page) {
        return EvaluationMapper.MAPPER.fromEntity(evaluationJpaRepository.listAll());
    }

    @Override
    public Evaluation insert(final Evaluation evaluation) {
        EvaluationEntity evaluationEntity = EvaluationMapper.MAPPER.toEntity(evaluation);
        evaluationEntity.persistAndFlush();
        return EvaluationMapper.MAPPER.fromEntity(evaluationEntity);
    }
}
