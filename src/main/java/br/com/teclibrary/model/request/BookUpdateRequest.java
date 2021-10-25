package br.com.teclibrary.model.request;

import br.com.teclibrary.model.data.Author;
import br.com.teclibrary.model.data.Gender;
import br.com.teclibrary.model.data.Publisher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequest {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private LocalDateTime releaseDate;
    @NotNull
    private List<Gender> genders;
    @NotNull
    private Author author;
    @NotNull
    private Publisher publisher;
    private String base64Image;
    private String base64File;
}
