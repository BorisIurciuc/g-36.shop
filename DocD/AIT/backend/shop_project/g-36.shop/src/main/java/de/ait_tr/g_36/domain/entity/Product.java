package de.ait_tr.g_36.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * 07/08/2024 g-36.shop * @author Boris Iurciuc (cohort36)
 */
@Entity
@Table(name = "product")
@Schema(description = "Class that describes Product") // add for Swagger
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @Schema( // add for Swagger
      description = "Product unique identifier",
      example = "111",
      accessMode = Schema.AccessMode.READ_ONLY
  )
  private Long id;

  @Column(name = "title")
  @Schema(description = "Product title", example = "banana") // add for Swagger
  private String title;

  @Column(name = "price")
  @Schema(description = "Product price", example = "190.00") // add for Swagger
  private BigDecimal price;

  @Column(name = "active")
  private boolean active;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
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
    if (!(o instanceof Product product)) {
      return false;
    }
    return Objects.equals(getId(), product.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId());
  }

  @Override
  public String toString() {
    return String.format("Product: id - %d, title - %s, price - %s, active - %s",
        id, title, price, active ? "yes" : "no");
  }


}
