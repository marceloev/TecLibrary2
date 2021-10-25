package br.com.teclibrary.model.request;

import br.com.teclibrary.model.data.enums.EvaluationRank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationInsertRequest {

    @NotNull
    private EvaluationRank rank;

    @NotNull
    private String feedback;

    @NotNull
    private Long bookId;
}
