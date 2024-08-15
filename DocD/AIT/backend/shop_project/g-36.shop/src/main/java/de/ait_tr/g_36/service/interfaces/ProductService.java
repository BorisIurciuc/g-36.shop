package de.ait_tr.g_36.service.interfaces;

import de.ait_tr.g_36.domain.dto.ProductDto;
import de.ait_tr.g_36.domain.entity.Product;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

  ProductDto save(ProductDto product);
  List<ProductDto> getAllProducts();
  ProductDto getById(Long id);
  ProductDto update(ProductDto product);
  void deleteById(Long id);
  void deleteByTitle(String title);
  void restoreById(Long id);
  long getAllActiveProductsQuantity();
  BigDecimal getAllActiveProductsTotalPrice();
  BigDecimal getAllActiveProductsAveragePrice();
}
