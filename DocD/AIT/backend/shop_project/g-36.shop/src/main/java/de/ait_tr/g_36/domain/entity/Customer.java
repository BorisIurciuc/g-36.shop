package de.ait_tr.g_36.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;

/**
 * 10/08/2024 g-36.shop * @author Boris Iurciuc (cohort36)
 */

@Entity
@Table(name = "customer")
@Schema(description = "Class that describes Customer")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @Schema( // add for Swagger
      description = "Customer unique identifier",
      example = "111",
      accessMode = Schema.AccessMode.READ_ONLY
  )
  private Long id;

  @Column(name = "name")
  @Schema(description = "Customer name", example = "Jon") // add for Swagger
  private String name;

  @Column(name = "active")
  private boolean active;

  @OneToOne
  private Cart cart;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Customer customer)) {
      return false;
    }
    return Objects.equals(getId(), customer.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId());
  }

  @Override
  public String toString() {
    return String.format("Customer: id - %d, name - %s, active - %s",
        id, name, active ? "yes" : "no");
  }


}