package br.com.teclibrary.model.data;

import br.com.teclibrary.model.data.enums.EvaluationRank;
import br.com.teclibrary.model.request.EvaluationInsertRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Evaluation {
    private Long id;
    private EvaluationRank rank;
    private String feedback;
    private Book book;
    private User user;

    public Evaluation(final EvaluationInsertRequest request, Book book, User user) {
        this.rank = request.getRank();
        this.feedback = request.getFeedback();
        this.book = book;
        this.user = user;
    }
}
