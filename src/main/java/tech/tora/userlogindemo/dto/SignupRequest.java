package tech.tora.userlogindemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
public class SignupRequest {
    private String username;
    private String email;
    private String password;
    private Set<String> roles;
}
