package guru.springframework.spring7reactive.mappers;

import guru.springframework.spring7reactive.domain.Customer;
import guru.springframework.spring7reactive.model.CustomerDTO;
import org.mapstruct.Mapper;

/**
 * spring-7-reactive
 *
 * @author Juliane Maran
 * @since 09/03/2026
 */
@Mapper
public interface CustomerMapper {

  Customer customerDtoToCustomer(CustomerDTO customerDTO);

  CustomerDTO customerToCustomerDto(Customer customer);

}
