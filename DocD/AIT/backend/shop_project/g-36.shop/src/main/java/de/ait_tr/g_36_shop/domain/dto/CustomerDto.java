package de.ait_tr.g_36_shop.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
  private CartDto cart;

  @Schema(description = "Customer name", example = "Jon") // add for Swagger
  private String name;

  public CartDto getCart() {
    return cart;
  }

  public void setCart(CartDto cart) {
    this.cart = cart;
  }
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
    return Objects.equals(getId(), that.getId()) && Objects.equals(getCart(),
        that.getCart()) && Objects.equals(getName(), that.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getCart(), getName());
  }

  @Override
  public String toString() {
    return "CustomerDto{" +
        "id=" + id +
        ", cart=" + cart +
        ", name='" + name + '\'' +
        '}';
  }
}