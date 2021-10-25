package br.com.teclibrary.model.request;

import br.com.teclibrary.model.data.enums.AppIdentifier;
import br.com.teclibrary.model.data.enums.UserRole;
import br.com.teclibrary.model.data.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInsertRequest {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @JsonIgnore
    private UserStatus status = UserStatus.PENDING;
    @JsonIgnore
    private UserRole role = UserRole.CUSTOMER;
    @JsonIgnore
    private AppIdentifier appIdentifier = AppIdentifier.TECLIBRARY;
}
