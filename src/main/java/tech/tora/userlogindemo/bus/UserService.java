package tech.tora.userlogindemo.bus;

import org.springframework.stereotype.Service;
import tech.tora.userlogindemo.model.User;

import java.util.List;

@Service
public interface UserService {
    public User addUser(User user);
    public User editUser(User user);
    public boolean isUserExist(User user);
    public List<User> getAllUser(User user);
}
