package br.com.teclibrary.domain;

import br.com.teclibrary.model.data.enums.UserRole;
import br.com.teclibrary.model.data.enums.UserStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Locale;

@Data
@Entity
@Table(name = "User")
public class UserEntity extends PanacheEntity {

    private String name;
    private String email;
    private String activation;
    private UserRole role;
    private UserStatus status;
}
