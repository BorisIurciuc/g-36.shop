package de.ait_tr.g_36.domain.dto;

import de.ait_tr.g_36.domain.entity.Product;

import java.util.List;
import java.util.Objects;

public class CartDto {

  private Long id;

  //private Customer customer;

  private List<Product> products;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProductsDto(List<Product> products) {
    this.products = products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CartDto cartDto)) {
      return false;
    }
    return Objects.equals(getId(), cartDto.getId()) && Objects.equals(
        getProducts(), cartDto.getProducts());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId());
  }
}
