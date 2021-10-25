package br.com.teclibrary.model.mapper;

import br.com.teclibrary.domain.EvaluationEntity;
import br.com.teclibrary.model.data.Evaluation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EvaluationMapper {

    EvaluationMapper MAPPER = Mappers.getMapper(EvaluationMapper.class);

    /**
     * Create a evaluation entity based on a evaluation data
     *
     * @param evaluation {@link Evaluation}
     * @return entity saved {@link EvaluationEntity}
     */
    EvaluationEntity toEntity(Evaluation evaluation);

    /**
     * Create a evaluation data based on a evaluation entity
     *
     * @param evaluationEntity {@link EvaluationEntity}
     * @return entity data {@link Evaluation}
     */
    Evaluation fromEntity(EvaluationEntity evaluationEntity);

    /**
     * Create a list of evaluation data based on a list of evaluation entity
     *
     * @param evaluationEntity list of {@link EvaluationEntity}
     * @return list of {@link Evaluation}
     */
    List<Evaluation> fromEntity(List<EvaluationEntity> evaluationEntity);
}
