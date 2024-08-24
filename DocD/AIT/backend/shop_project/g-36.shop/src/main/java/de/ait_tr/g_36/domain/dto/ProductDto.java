package de.ait_tr.g_36.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * 07/08/2024 g-36.shop * @author Boris Iurciuc (cohort36)
 */
@Schema(description = "Class that describes Product") // add for Swagger
public class ProductDto {

  @Schema( // add for Swagger
      description = "Product unique identifier",
      example = "111",
      accessMode = Schema.AccessMode.READ_ONLY
  )
  private Long id;

  @Schema(description = "Product title", example = "banana") // add for Swagger
  private String title;

  @Schema(description = "Product price", example = "190.00") // add for Swagger
  private BigDecimal price;

  //private boolean active;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ProductDto that)) {
      return false;
    }
    return Objects.equals(getId(), that.getId()) && Objects.equals(getTitle(),
        that.getTitle()) && Objects.equals(getPrice(), that.getPrice());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getTitle(), getPrice());
  }

  @Override
  public String toString() {
    return String.format("Product: id - %d, title - %s, price - %s",
        id, title, price);
  }


}
