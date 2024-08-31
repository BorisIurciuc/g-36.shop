package de.ait_tr.g_36_shop.repository;

import de.ait_tr.g_36_shop.domain.entity.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

  Optional<Customer> findByName(String name);

}
