package tech.tora.userlogindemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class LoginRequest {
    private String username;
    private String password;
}
