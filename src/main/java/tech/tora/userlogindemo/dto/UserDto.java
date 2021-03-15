package tech.tora.userlogindemo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDto implements Serializable {
    private String name;
    private String email;
    private Long role;
}
