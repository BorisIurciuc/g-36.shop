package de.ait_tr.g_36.service;

import de.ait_tr.g_36.domain.entity.Customer;
import de.ait_tr.g_36.service.interfaces.CustomerServices;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerServicesImpl implements CustomerServices {

  @Override
  public Customer saveCustomer(Customer customer) {
    return customer;
  }

  @Override
  public List<Customer> getAllCustomers() {
    return List.of();
  }

  @Override
  public Customer getCustomerById(Long id) {
    return null;
  }

  @Override
  public Customer updateCustomer(Customer customer) {
    return customer;
  }

  @Override
  public void deleteCustomerById(Long id) {

  }

  @Override
  public void deleteCustomerByName(String name) {

  }

  @Override
  public void restoreCustomer(Long id) {

  }

  @Override
  public long getAllActiveCustomersQuantity() {
    return 0;
  }

  @Override
  public BigDecimal getCustomerCartPriceTotalById(Long id) {
    return null;
  }

  @Override
  public BigDecimal getCustomerCartPriceAverageById(Long id) {
    return null;
  }

  @Override
  public Customer addProductToCart(Customer customer) {
    return null;
  }

  @Override
  public void deleteProductByIdFromCart(Customer customer) {

  }

  @Override
  public void deleteProductsAllFromCart(Customer customer) {

  }
}
