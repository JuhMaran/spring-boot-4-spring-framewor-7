package guru.springframework.kberestbrewery.mappers;

import guru.springframework.kberestbrewery.domain.Customer;
import guru.springframework.kberestbrewery.model.CustomerDto;
import org.mapstruct.Mapper;

/**
 * kbe-rest-brewery
 *
 * @author Juliane Maran
 * @since 03/04/2026
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {

  Customer customerDtoToCustomer(CustomerDto dto);

  CustomerDto customerToCustomerDto(Customer customer);

}
