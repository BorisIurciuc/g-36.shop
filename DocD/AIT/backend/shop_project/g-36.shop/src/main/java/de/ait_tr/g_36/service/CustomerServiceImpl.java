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

  private CustomerRepository repository;
  private CustomerMappingService mappingService;

  public CustomerServiceImpl(CustomerRepository repository, CustomerMappingService mappingService) {
    this.repository = repository;
    this.mappingService = mappingService;
  }

  @Override
  public CustomerDto save(CustomerDto dto) {
    Customer entity = mappingService.mapDtoToEntity(dto);
    repository.save(entity);
    return mappingService.mapEntityToDto(entity);
  }

  @Override
  public List<CustomerDto> getAllActiveCustomers() {
    return repository.findAll()
        .stream()
        .map(mappingService::mapEntityToDto)
        .toList();
  }

  @Override
  public CustomerDto getById(Long id) {
    Customer customer = repository.findById(id).orElse(null);
      if(customer != null && customer.isActive()) {
        return mappingService.mapEntityToDto(customer);
      }
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
