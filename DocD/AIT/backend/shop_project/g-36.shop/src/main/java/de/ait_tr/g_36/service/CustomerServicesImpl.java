package de.ait_tr.g_36.service;

import de.ait_tr.g_36.domain.entity.Customer;
import de.ait_tr.g_36.repository.CustomerRepository;
import de.ait_tr.g_36.service.interfaces.CustomerServices;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerServicesImpl implements CustomerServices {

  private CustomerRepository repository;

  public CustomerServicesImpl(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public Customer save(Customer customer) {
    return repository.save(customer);
  }

  @Override
  public List<Customer> getAllActiveCustomers() {
    return repository.findAll()
        .stream()
        .filter(Customer::isActive)
        .toList();
  }

  @Override
  public Customer getById(Long id) {
    Customer customer = repository.findById(id).orElse(null);
      if(customer != null && customer.isActive()) {
        return customer;
      }
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
