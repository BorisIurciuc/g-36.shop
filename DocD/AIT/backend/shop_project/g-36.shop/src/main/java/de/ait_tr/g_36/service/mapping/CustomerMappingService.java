package de.ait_tr.g_36.service.mapping;

import de.ait_tr.g_36.domain.dto.CustomerDto;
import de.ait_tr.g_36.domain.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;



@Mapper(componentModel = "spring")
public interface CustomerMappingService {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "active", constant = "true")

  Customer mapDtoToEntity(CustomerDto dto);
  CustomerDto mapEntityToDto(Customer entry);
}
