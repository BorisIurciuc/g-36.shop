package de.ait_tr.g_36_shop.service.interfaces;

import de.ait_tr.g_36_shop.domain.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {

  //UserDetailsService loadUserByUsername(String username) throws UsernameNotFoundException;
  void register(User user);

  void registrationConfirm(String code);

}
