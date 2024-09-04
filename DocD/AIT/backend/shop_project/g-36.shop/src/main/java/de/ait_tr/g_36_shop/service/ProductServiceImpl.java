package de.ait_tr.g_36_shop.service;

import de.ait_tr.g_36_shop.domain.dto.ProductDto;
import de.ait_tr.g_36_shop.domain.entity.Product;
import de.ait_tr.g_36_shop.exeption_handling.exeptions.ForthTestException;
import de.ait_tr.g_36_shop.exeption_handling.exeptions.ProductNotFoundException;
import de.ait_tr.g_36_shop.repository.ProductRepository;
import de.ait_tr.g_36_shop.service.interfaces.ProductService;
import de.ait_tr.g_36_shop.service.mapping.ProductMappingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository repository;
  private final ProductMappingService mappingService;

  public ProductServiceImpl(ProductRepository repository, ProductMappingService mappingService) {
    this.repository = repository;
    this.mappingService = mappingService;
  }

  @Override
  public ProductDto save(ProductDto dto) {
    Product entity = mappingService.mapDtoToEntity(dto);
    repository.save(entity);
    return mappingService.mapEntityToDto(entity);
  }

  @Override
  public List<ProductDto> getAllProducts() {
    return repository.findAll()
        .stream()
        .map(mappingService::mapEntityToDto)
        .toList();
  }


   @Override
//   @NotNull(message = "Product title can't be null")
//   public ProductDto getById(Long id) {
//     Product product = repository.findById(id).orElse(null);
//     if(product != null && product.isActive()){
//       return mappingService.mapEntityToDto(product);
//     }
//     return null;
//   }

   public ProductDto getById(Long id) {
     Product product = repository.findById(id).orElseThrow(() ->
         new ForthTestException("Product with ID " + id + " not found"));

     if (!product.isActive()) {
       throw new ForthTestException("Product with ID " + id + " is not active");
     }

     return mappingService.mapEntityToDto(product);
   }


  @Override
  //@Transactional
  public ProductDto update(ProductDto dto) {
    Product existingProduct = repository.findById(dto.getId())
        .orElseThrow(() -> new ProductNotFoundException(dto.getId()));

    // Debug log to print the existing product before updating
    System.out.println("Existing Product: " + existingProduct);

    // Update fields
    existingProduct.setTitle(dto.getTitle());
    existingProduct.setPrice(dto.getPrice());

    // Debug log to print the updated product
    System.out.println("Updated Product: " + existingProduct);

    Product updatedProduct = repository.save(existingProduct);

    return mappingService.mapEntityToDto(updatedProduct);
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    product.setActive(false);
    repository.save(product); // Save the entity to ensure it’s persisted
  }

  @Override
  @Transactional
  public void deleteByTitle(String title) {
    Product product = repository.findByTitle(title).orElse(null);
    if (product == null) {
      throw new ProductNotFoundException(title);
    }
    product.setActive(false);
  }

  @Override
  @Transactional
  public void restoreById(Long id) {
    Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    product.setActive(true);
  }

  @Override
  public long getAllActiveProductsQuantity() {
    return 0;
  }

  @Override
  public BigDecimal getAllActiveProductsTotalPrice() {
    return null;
  }

  @Override
  public BigDecimal getAllActiveProductsAveragePrice() {
    return null;
  }

  @Override
  @Transactional
  public void attachImage(String imgUrl, String productTitle) {

    Product product = repository.findByTitle(productTitle).orElseThrow(
        () -> new RuntimeException("Product not found")
    );
    product.setImage(imgUrl);
  }
}
