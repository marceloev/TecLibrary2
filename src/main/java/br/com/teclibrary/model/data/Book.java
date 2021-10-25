package br.com.teclibrary.model.data;

import br.com.teclibrary.model.request.BookInsertRequest;
import br.com.teclibrary.model.request.BookUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime releaseDate;
    private List<Gender> genders;
    private Author author;
    private Publisher publisher;
    private File image;
    private File file;

    public Book(final BookInsertRequest request) {
        this.name = request.getName();
        this.description = request.getDescription();
        this.releaseDate = request.getReleaseDate();
        this.genders = request.getGenders();
        this.author = request.getAuthor();
        this.publisher = request.getPublisher();
    }

    public void update(final BookUpdateRequest request) {
        this.name = request.getName();
        this.description = request.getDescription();
        this.releaseDate = request.getReleaseDate();
        this.genders = request.getGenders();
        this.author = request.getAuthor();
        this.publisher = request.getPublisher();
    }
}
