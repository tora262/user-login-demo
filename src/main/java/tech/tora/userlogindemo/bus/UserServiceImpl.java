package tech.tora.userlogindemo.bus;

import org.springframework.stereotype.Service;
import tech.tora.userlogindemo.dal.UserRepository;
import tech.tora.userlogindemo.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User editUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean isUserExist(User user) {
        List<User> users = userRepository.findAllByEmailOrUsername(
                user.getUsername(), user.getEmail());
        if (users.stream().count() == 0) return false;
        return true;
    }

    @Override
    public List<User> getAllUser(User user) {
        return userRepository.findAll();
    }
}
