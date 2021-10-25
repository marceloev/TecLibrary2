package br.com.teclibrary.domain;

import br.com.teclibrary.model.data.enums.FileType;
import br.com.teclibrary.model.data.enums.StorageType;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "File")
public class FileEntity extends PanacheEntity {

    @Column(name = "[key]")
    private String key;
    private FileType type;
    private StorageType storage;
}
