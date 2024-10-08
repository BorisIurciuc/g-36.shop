package de.ait_tr.g_36_shop.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * 14/08/2024 g-36.shop * @author Boris Iurciuc (cohort36)
 */

@Entity
@Table(name = "cart")
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;


@OneToOne
@JoinColumn(name = "customer_id")
  private Customer customer;

  @ManyToMany
  @JoinTable(
      name = "cart_product",
      joinColumns = @JoinColumn(name = "cart_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id")
  )
  private List<Product> products;

  //cart methods

  private void  addProduct(Product product) {
    if(product.isActive()) {
      products.add(product);
    }
  }

  public List<Product> getAllActiveProducts() {
    return products.stream()
        .filter(Product::isActive)
        .toList();
  }

  public void removeProductById(Long id) {
    Iterator<Product> iterator = products.iterator();
    while(iterator.hasNext()) {
      if(iterator.next().getId().equals(id)){
        iterator.remove();
        break;
      }
    }
  }

  public void clear() {
    products.clear();
  }

  public BigDecimal getActiveProductsTotalCost() {
    return products.stream()
        .filter(Product::isActive)
        .map(Product::getPrice)
        .reduce(BigDecimal::add)
        .orElse(BigDecimal.ZERO);
  }

  public BigDecimal getActiveProductsAverageCost() {
    int count = getAllActiveProducts().size();

    if(count == 0) {
      return BigDecimal.ZERO;
    }

    return getActiveProductsTotalCost().divide(new BigDecimal(count), RoundingMode.DOWN);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Cart cart)) {
      return false;
    }
    return Objects.equals(getId(), cart.getId()) && Objects.equals(getCustomer(),
        cart.getCustomer()) && Objects.equals(getProducts(), cart.getProducts());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId());
  }

  @Override
  public String toString() {
    return String.format("Cart: id - %d, contains %d products", id, products == null ? 0 : products.size());
  }
}
