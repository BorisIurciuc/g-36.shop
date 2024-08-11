package de.ait_tr.g_36.controller;

import de.ait_tr.g_36.domain.entity.Customer;
import de.ait_tr.g_36.service.interfaces.CustomerServices;
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
public class CustomerController {
  private final CustomerServices service;

  public CustomerController(CustomerServices service) {
    this.service = service;
  }

  @GetMapping("/test")
  public String test() {
    return "CustomerController is working";
  }

  @PostMapping("/save")
  public Customer saveCustomer(@RequestBody Customer customer) {
    return service.saveCustomer(customer);
  }

  @GetMapping("/read")
  public List<Customer> getCustomer(@RequestParam(required = false) Long id) {
    if (id == null) {
      return service.getAllCustomers();
    } else {
      Customer customer = service.getCustomerById(id);
      if (customer == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
      }
      return List.of(customer);
    }
  }

  @PutMapping("/update")
  public Customer updateCustomer(@RequestBody Customer customer) {
    return service.updateCustomer(customer);
  }

  @DeleteMapping("/delete")
  public void deleteCustomer(@RequestParam(required = false) Long id, @RequestParam(required = false) String name) {
    if (id != null) {
      service.deleteCustomerById(id);
    } else if (name != null) {
      service.deleteCustomerByName(name);
    }
  }

  @PutMapping("/restore")
  public void restoreCustomer(@RequestParam Long id) {
    service.restoreCustomer(id);
  }

  @GetMapping("/quantity")
  public long getAllActiveCustomersQuantity() {
    return service.getAllActiveCustomersQuantity();
  }

  @GetMapping("/total-price")
  public BigDecimal getCustomerCartPriceTotalById(@RequestParam Long id) {
    return service.getCustomerCartPriceTotalById(id);
  }

  @GetMapping("/avarage-price")
  public BigDecimal getCustomerCartPriceAverageById(@RequestParam Long id) {
    return service.getCustomerCartPriceAverageById(id);
  }

  @PostMapping("/cart/add")
  public Customer addProductToCart(@RequestBody Customer customer) {
    return customer;
  }
  @DeleteMapping("/cart/delete")
  public void deleteProductFromCart(@RequestParam Long id, @RequestParam(required = false) Long productId) {
//    if (productId == null) {
//      service.deleteProductsAllFromCart(id);
//    } else {
//      service.deleteProductByIdFromCart(id, productId);
//    }
  }
}
