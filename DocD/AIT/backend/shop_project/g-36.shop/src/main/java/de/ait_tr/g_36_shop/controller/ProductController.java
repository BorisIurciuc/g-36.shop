package de.ait_tr.g_36_shop.controller;

import de.ait_tr.g_36_shop.domain.dto.ProductDto;
import de.ait_tr.g_36_shop.exeption_handling.Response;
import de.ait_tr.g_36_shop.exeption_handling.exeptions.FirstTestException;
import de.ait_tr.g_36_shop.service.interfaces.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Tag(
    name = "Product controller",
    description = "Controller for various operations with Products"
) // add for Swagger
public class ProductController {

  //DI
  private final ProductService service;

  public ProductController(ProductService service) {
    this.service = service;
  }

  @GetMapping("/test")
  public String test() {
    return "ProductController is working";
  }

  // CRUD - Create(POST), Read (GET), Update (PUT), Delete (DELETE)
  // Три уровня доступа к приложению:
  // 1. Получить все продукты могут все пользователи, в том числе анонимные
  // 2. Получить продукт по идентификатору могут только аутентифицированные пользователи с любой ролью
  // 3. Сохранить продукт в базу данных может только администратор

  @PostMapping
  public ProductDto save(
                      @RequestBody
                      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Instance of a Product")
                      ProductDto product
  ){
    return service.save(product);
  }
  // Read: GET -> localhost:8080/products?id=3
  @Operation(
      summary = "Get product by id",
      description = "Getting one product that exists in the database by its id"
  )
  @GetMapping
  public ProductDto getById(
      @RequestParam
      @Parameter(description = "Product unique identifier")
      Long id
  ) {
    return service.getById(id);
  }
//  public List<ProductDto> get(@RequestParam(required = false) Long id) {
//    //TODO обращаемся к серверу
//    if (id == null) {
//      return service.getAllProducts();
//    } else {
//      ProductDto product = service.getById(id);
//      return product == null ? null : List.of(product);
//    }
//  }

  @GetMapping("/all")
  public List<ProductDto> getAll() {
    return service.getAllProducts();
  }

  @PutMapping
  public ProductDto update(@RequestBody ProductDto product){
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

  @GetMapping("/total-price")
  public BigDecimal getTotalPrice(){
    return service.getAllActiveProductsTotalPrice();
  }

  @GetMapping("/average-price")
  public BigDecimal getAveragePrice(){
    return service.getAllActiveProductsAveragePrice();
  }

  // user call product with wrong id
  // ПЛЮС - точечно настраиваем обработчик ошибок именно для данного контроллера,
// если нам требуется разная логика обработки исключений в разных контроллерах
// МИНУС - если нам не требуется разная логика для разных контроллеров,
// придётся создавать такие обработчики в каждом контроллере отдельно
  @ExceptionHandler(FirstTestException.class)
  public Response handException(FirstTestException e) {
    return new Response (e.getMessage());
  }
}
