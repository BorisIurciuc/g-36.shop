package de.ait_tr.g_36.repository;

import de.ait_tr.g_36.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
