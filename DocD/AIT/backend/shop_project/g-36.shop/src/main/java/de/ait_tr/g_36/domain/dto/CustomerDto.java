package de.ait_tr.g_36.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

/**
 * 10/08/2024 g-36.shop * @author Boris Iurciuc (cohort36)
 */

@Schema(description = "Class that describes Customer")
public class CustomerDto {

  @Schema( // add for Swagger
      description = "Customer unique identifier",
      example = "111",
      accessMode = Schema.AccessMode.READ_ONLY
  )
  private Long id;

  @Schema(description = "Customer name", example = "Jon") // add for Swagger
  private String name;

  //private boolean active;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CustomerDto that)) {
      return false;
    }
    return Objects.equals(getId(), that.getId()) && Objects.equals(getName(),
        that.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId());
  }

  @Override
  public String toString() {
    return String.format("Customer: id - %d, name - %s, active - %s",
        id, name);
  }
}