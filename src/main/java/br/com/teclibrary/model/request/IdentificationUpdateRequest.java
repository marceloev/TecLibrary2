package br.com.teclibrary.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationUpdateRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String activation;
}
