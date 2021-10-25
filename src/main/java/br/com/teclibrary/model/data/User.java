package br.com.teclibrary.model.data;

import br.com.teclibrary.model.data.enums.UserRole;
import br.com.teclibrary.model.data.enums.UserStatus;
import br.com.teclibrary.model.request.UserInsertRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private String email;
    @Getter(onMethod_ = @JsonIgnore)
    private String activation;
    @Getter(onMethod_ = @JsonIgnore)
    private UserRole role;
    @Getter(onMethod_ = @JsonIgnore)
    private UserStatus status;

    public User(final UserInsertRequest request) {
        this.name = request.getName();
        this.email = request.getEmail();
        this.activation = UUID.randomUUID().toString();
        this.role = request.getRole();
        this.status = request.getStatus();
    }
}
