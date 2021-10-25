package br.com.teclibrary.domain;

import br.com.teclibrary.model.data.enums.AppIdentifier;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Identification")
public class IdentificationEntity extends PanacheEntity {
    private Long userId;
    private AppIdentifier appIdentifier;
    private String password;
}
