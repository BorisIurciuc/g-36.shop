package de.ait_tr.g_36_shop.repository;

import de.ait_tr.g_36_shop.domain.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String name);

}
