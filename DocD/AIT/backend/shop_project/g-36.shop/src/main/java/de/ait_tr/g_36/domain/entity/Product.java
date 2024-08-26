package de.ait_tr.g_36.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

  @NotNull(message = "Product title can't be null")
  @NotBlank(message = "Product title can't be null")
  @Pattern(
      regexp = "[A-Z][a-z ]{2,}",
      message = "Product title should start with capital letter, at least 3 character length"
  )
  private String title;

  @Column(name = "price")
  @Schema(description = "Product price", example = "190.00") // add for Swagger
  @DecimalMin(
      value = "3.00",
      message = "Price should be greater than 3.00"
  )
  @DecimalMax(
      value = "100000.00",
      inclusive = false,
      message = "Price should be less than 100000.00"
  )
  private BigDecimal price;

  @Column(name = "active")
  private boolean active;

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public boolean isActive() {
    return active;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return active == product.active && Objects.equals(id, product.id) && Objects.equals(title, product.title) && Objects.equals(price, product.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, price, active);
  }

  @Override
  public String toString() {
    return String.format("Product: id - %d, title - %s, price - %s, active - %s",
        id, title, price, active ? "yes" : "no");
  }
}
