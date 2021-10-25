package br.com.teclibrary.model.data;

import br.com.teclibrary.model.request.GenderInsertRequest;
import br.com.teclibrary.model.request.GenderUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Gender {

    private Long id;
    private String name;

    public Gender(final GenderInsertRequest request) {
        this.name = request.getName();
    }

    public void update(final GenderUpdateRequest request) {
        this.name = request.getName();
    }
}
