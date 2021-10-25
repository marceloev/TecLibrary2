package br.com.teclibrary.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "Publisher")
public class PublisherEntity extends PanacheEntity {
    private String name;

    @OneToMany(mappedBy = "publisher")
    private List<BookEntity> books;
}
