package de.ait_tr.g_36.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;

/**
 * 17/08/2024 g-36.shop * @author Boris Iurciuc (cohort36)
 */

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "title")
  private String title;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Role role)) {
      return false;
    }
    return Objects.equals(getId(), role.getId()) && Objects.equals(getTitle(),
        role.getTitle());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getTitle());
  }

  @Override
  public String toString() {
    return String.format("Role: id=%d, title=%s", id, title);
  }

  @Override
  public String getAuthority() {
    return title;
  }
}
