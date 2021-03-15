package tech.tora.userlogindemo.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.tora.userlogindemo.common.ERole;
import tech.tora.userlogindemo.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole role);
}
