package de.ait_tr.g_36_shop.exeption_handling.exeptions;

public class ProductNotFoundException extends RuntimeException {

  public ProductNotFoundException(Long productId) {
    super(String.format("Product with id %d not found", productId));
  }

  public ProductNotFoundException(String productTitle) {
    super(String.format("Product with title %s not found", productTitle));
  }
}
