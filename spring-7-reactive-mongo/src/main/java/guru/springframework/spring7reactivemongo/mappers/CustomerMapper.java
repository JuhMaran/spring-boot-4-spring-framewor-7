package guru.springframework.spring7reactivemongo.mappers;

import guru.springframework.spring7reactivemongo.domain.Customer;
import guru.springframework.spring7reactivemongo.model.CustomerDTO;
import org.mapstruct.Mapper;

/**
 * spring-7-reactive-mongo
 *
 * @author Juliane Maran
 * @since 12/03/2026
 */
@Mapper
public interface CustomerMapper {

  CustomerDTO customerToCustomerDto(Customer customer);

  Customer customerDtoToCustomer(CustomerDTO customerDTO);

}
