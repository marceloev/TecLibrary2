package br.com.teclibrary.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAuthenticationResponse {
    private Long userId;
    private String name;
    private String email;
    private String token;
}
