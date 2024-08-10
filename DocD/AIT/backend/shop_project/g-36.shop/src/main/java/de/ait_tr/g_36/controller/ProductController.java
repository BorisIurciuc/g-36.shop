package de.ait_tr.g_36.controller;

import de.ait_tr.g_36.domain.entity.Product;
import de.ait_tr.g_36.service.interfaces.ProductService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 09/08/2024 g-36.shop * @author Boris Iurciuc (cohort36)
 */
@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService service;

  public ProductController(ProductService service) {
    this.service = service;
  }

  // CRUD - Create(POST), Read (GET), Update (PUT), Delete (DELETE)
  @PostMapping
  public Product save(@RequestBody Product product){
    return service.save(product);
  }

  @GetMapping()
  public List<Product> get(@RequestParam(required = false) Long id) {
    //TODO обращаемся к серверу
    if (id == null) {
      return service.getAllProducts();
    } else {
      Product product = service.getById(id);
      return product == null ? null : List.of(product);
    }
  }

  @PutMapping
  public Product update(@RequestBody Product product){
    return service.update(product);
  }

  @DeleteMapping
  public void delete(@RequestParam(required = false) Long id, @RequestParam(required = false) String title){
    if (id != null) {
      service.deleteById(id);
    } else if (title != null) {
      service.deleteByTitle(title);
    }
  }

  @PutMapping("/restore")
  public void restore(@RequestParam Long id){
    service.restoreById(id);
  }

  @GetMapping("/quantity")
  public long getProductQuantity(){
    return service.getAllActiveProductsQuantity();
  }

  @GetMapping("/total/price")
  public BigDecimal getTotalPrice(){
    return service.getAllActiveProductsTotalPrice();
  }

  @GetMapping("/average-price")
  public BigDecimal getAveragePrice(){
    return service.getAllActiveProductsAveragePrice();
  }
}
