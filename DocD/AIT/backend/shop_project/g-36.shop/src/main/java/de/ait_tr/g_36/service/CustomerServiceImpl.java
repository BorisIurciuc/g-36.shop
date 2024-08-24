package de.ait_tr.g_36.service;

import de.ait_tr.g_36.domain.dto.CustomerDto;
import de.ait_tr.g_36.domain.entity.Customer;
import de.ait_tr.g_36.repository.CustomerRepository;
import de.ait_tr.g_36.service.interfaces.CustomerService;
import de.ait_tr.g_36.service.mapping.CustomerMappingService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

//  private final CustomerRepository repository;
//  private final CustomerMappingService mappingService;
//
//  public CustomerServiceImpl(CustomerRepository repository, CustomerMappingService mappingService) {
//    this.repository = repository;
//    this.mappingService = mappingService;
//  }

  @Override
  public CustomerDto save(CustomerDto dto) {
    return null;
  }

  @Override
  public List<CustomerDto> getAllActiveCustomers() {
    return null;
  }

  @Override
  public CustomerDto getById(Long id) {

          return null;
  }

  @Override
  public CustomerDto update(CustomerDto customer) {
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
  public CustomerDto addProductToCustomersCart(Long customerId, Long productId) {
    return null;
  }

  @Override
  public void removeProductFromCustomersCart(Long customerId, Long productId) {

  }

  @Override
  public void clearCustomersCart(Long customerId) {

  }
}
