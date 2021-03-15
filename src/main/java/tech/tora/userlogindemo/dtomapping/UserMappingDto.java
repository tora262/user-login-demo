package tech.tora.userlogindemo.dtomapping;

import org.springframework.stereotype.Component;
import tech.tora.userlogindemo.dto.UserDto;
import tech.tora.userlogindemo.model.User;

@Component
public class UserMappingDto {
    public static UserDto mapToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getUsername());
//        userDto.setRole(user.getRole());

        return userDto;
    }
}
