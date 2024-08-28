package de.ait_tr.g_36.service;

import de.ait_tr.g_36.domain.dto.ProductDto;
import de.ait_tr.g_36.domain.entity.Product;
import de.ait_tr.g_36.exeption_handling.exeptions.ForthTestException;
import de.ait_tr.g_36.exeption_handling.exeptions.ThirdTestException;
import de.ait_tr.g_36.repository.ProductRepository;
import de.ait_tr.g_36.service.interfaces.ProductService;
import de.ait_tr.g_36.service.mapping.ProductMappingService;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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
  public ProductDto update(ProductDto product) {
    return null;
  }

  @Override
  public void deleteById(Long id) {

  }

  @Override
  public void deleteByTitle(String title) {

  }

  @Override
  public void restoreById(Long id) {

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
}
