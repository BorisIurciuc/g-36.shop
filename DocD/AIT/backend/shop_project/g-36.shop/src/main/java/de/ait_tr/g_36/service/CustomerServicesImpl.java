package de.ait_tr.g_36.service;

import de.ait_tr.g_36.domain.entity.Customer;
import de.ait_tr.g_36.service.interfaces.CustomerServices;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerServicesImpl implements CustomerServices {


  @Override
  public Customer save(Customer customer) {
    return null;
  }

  @Override
  public List<Customer> getAllActiveCustomers() {
    return List.of();
  }

  @Override
  public Customer getById(Long id) {
    return null;
  }

  @Override
  public Customer update(Customer customer) {
    return null;
  }

  @Override
  public void deleteById(Long id) {

  }

  @Override
  public void deleteByName(String name) {

  }

  @Override
  public void restoreById(Long id) {

  }

  @Override
  public long getActiveCustomersNumber() {
    return 0;
  }

  @Override
  public BigDecimal getTotalCostOfCustomersProduct(Long customerId) {
    return null;
  }

  @Override
  public BigDecimal getAverageCostOfCustomersProduct(Long customerId) {
    return null;
  }

  @Override
  public Customer addProductToCustomersCart(Long customerId, Long productId) {
    return null;
  }

  @Override
  public void removeProductFromCustomersCart(Long customerId, Long productId) {

  }

  @Override
  public void clearCustomersCart(Long customerId) {

  }
}
