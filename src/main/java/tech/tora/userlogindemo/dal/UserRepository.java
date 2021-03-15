package tech.tora.userlogindemo.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.tora.userlogindemo.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByEmailOrUsername(String name, String email);
    User findByUsername(String name);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String name);
}
