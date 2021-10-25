package br.com.teclibrary.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Gender")
public class GenderEntity extends PanacheEntity {
    private String name;
}
