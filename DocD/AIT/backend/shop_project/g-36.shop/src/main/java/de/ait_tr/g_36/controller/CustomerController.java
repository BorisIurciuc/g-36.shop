package de.ait_tr.g_36.controller;

import de.ait_tr.g_36.domain.entity.Customer;
import de.ait_tr.g_36.service.interfaces.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/customers")
@Tag(
    name = "Customer controller",
    description = "Controller for various operations with Customer"
) // add for Swagger
public class CustomerController {

  private final CustomerService service;

  public CustomerController(CustomerService service) {
    this.service = service;
  }

  @GetMapping("/test")
  public String test() {
    return "CustomerController is working";
  }

  @PostMapping
  public Customer save(@RequestBody
                      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Instance of a Customer")
                      Customer customer) {
    return service.save(customer);
  }

  @GetMapping
  public List<Customer> get(@RequestParam(required = false) Long id) {
    if (id == null) {
      return service.getAllActiveCustomers();
    } else {
      Customer customer = service.getById(id);
      if (customer == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
      }
      return List.of(customer);
    }
  }

  @PutMapping("/update")
  public Customer update(@RequestBody Customer customer) {
    return service.update(customer);
  }

  @DeleteMapping("/delete")
  public void deleteCustomer(@RequestParam(required = false) Long id,
      @RequestParam(required = false) String name) {
    if (id != null) {
      service.deleteById(id);
    } else if (name != null) {
      service.deleteByName(name);
    }
  }

  @PutMapping("/restore")
  public void restoreById(@RequestParam Long id) {
    service.restoreById(id);
  }

  @GetMapping("/quantity")
  public long getActiveCustomersNumber() {
    return service.getActiveCustomersNumber();
  }

  @GetMapping("/total-price")
  public BigDecimal getTotalCostOfCustomersProduct(@RequestParam Long id) {
    return service.getTotalCostOfCustomersProduct(id);
  }

  @GetMapping("/avarage-price")
  public BigDecimal getCustomerCartPriceAverageById(@RequestParam Long id) {
    return service.getAverageCostOfCustomersProduct(id);
  }

  @PostMapping("/cart/add")
  public Customer addProductToCustomersCart(@RequestBody Customer customer) {
    return customer;
  }
//  @DeleteMapping("/cart/delete")
//  public void delete(@RequestParam Long id, @RequestParam(required = false) Long productId) {
//    if (productId == null) {
//      service.deleteProductsAllFromCart(id);
//    } else {
//      service.deleteProductByIdFromCart(id, productId);
//    }
//  }
}
