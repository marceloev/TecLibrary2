package br.com.teclibrary.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Book")
public class BookEntity extends PanacheEntity {

    private String name;
    private String description;
    private LocalDateTime releaseDate;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<GenderEntity> genders;

    @ManyToOne(fetch = FetchType.EAGER)
    private AuthorEntity author;

    @ManyToOne(fetch = FetchType.EAGER)
    private PublisherEntity publisher;

    @OneToOne(fetch = FetchType.EAGER)
    private FileEntity image;

    @OneToOne(fetch = FetchType.EAGER)
    private FileEntity file;
}
