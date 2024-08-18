package de.ait_tr.g_36.repository;

import de.ait_tr.g_36.domain.entity.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

  Optional<Role> findByTitle(String title);
}
