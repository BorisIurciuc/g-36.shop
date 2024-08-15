package de.ait_tr.g_36.service.mapping;

import de.ait_tr.g_36.domain.dto.CustomerDto;
import de.ait_tr.g_36.domain.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

/**
 * 15/08/2024 g-36.shop * @author Boris Iurciuc (cohort36)
 */

@Service
@Mapper(componentModel = "spring")
public interface CustomerMappingService {

  Customer mapDtoToEntity(CustomerDto dto);

  CustomerDto mapEntityToDto(Customer entry);
}
