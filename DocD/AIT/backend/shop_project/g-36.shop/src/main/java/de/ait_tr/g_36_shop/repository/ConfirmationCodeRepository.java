package de.ait_tr.g_36_shop.repository;

import de.ait_tr.g_36_shop.domain.entity.ConfirmationCode;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationCodeRepository extends JpaRepository<ConfirmationCode, Long> {

  Optional<ConfirmationCode> findByCode(String code);



}
