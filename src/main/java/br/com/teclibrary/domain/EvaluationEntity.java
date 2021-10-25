package br.com.teclibrary.domain;

import br.com.teclibrary.model.data.enums.EvaluationRank;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Evaluation")
public class EvaluationEntity extends PanacheEntity {
    private EvaluationRank rank;
    private String feedback;
    @OneToOne
    private BookEntity book;
    @OneToOne
    private UserEntity user;
}
