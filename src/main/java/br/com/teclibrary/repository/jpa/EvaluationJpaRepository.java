package br.com.teclibrary.repository.jpa;

import br.com.teclibrary.domain.EvaluationEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class EvaluationJpaRepository implements PanacheRepository<EvaluationEntity> {
}
