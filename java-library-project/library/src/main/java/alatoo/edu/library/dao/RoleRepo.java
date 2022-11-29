package alatoo.edu.library.dao;

import alatoo.edu.library.models.entities.Role;
import alatoo.edu.library.models.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
