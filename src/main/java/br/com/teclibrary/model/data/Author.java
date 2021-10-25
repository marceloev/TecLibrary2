package br.com.teclibrary.model.data;

import br.com.teclibrary.model.request.AuthorInsertRequest;
import br.com.teclibrary.model.request.AuthorUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private Long id;
    private String name;

    public Author(final AuthorInsertRequest request) {
        this.name = request.getName();
    }

    public void update(final AuthorUpdateRequest request) {
        this.id = request.getId();
        this.name = request.getName();
    }
}
