package de.ait_tr.g_36.security;

import de.ait_tr.g_36.domain.entity.Role;
import java.util.Collection;
import java.util.Set;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 20/08/2024 g-36.shop
 *
 * @author Boris Iurciuc (cohort36)
 */
public class AuthInfo implements Authentication {


  // current user info for Spring Security Context
  //fields
  private boolean authenticated;
  private String username;
  private Set<Role> roles;

  // constructor
  public AuthInfo(String username, Set<Role> roles) {
    this.username = username;
    this.roles = roles;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles;
  }

  // not using
  @Override
  public Object getCredentials() {
    return null;
  }

  // not using
  @Override
  public Object getDetails() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return username;
  }

  @Override
  public boolean isAuthenticated() {
    return authenticated;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    this.authenticated = authenticated;
  }

  @Override
  public String getName() {
    return username;
  }
}
