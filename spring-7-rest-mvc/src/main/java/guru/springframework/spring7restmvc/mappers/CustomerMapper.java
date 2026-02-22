package guru.springframework.spring7restmvc.mappers;

import guru.springframework.spring7restmvc.entities.Customer;
import guru.springframework.spring7restmvc.model.CustomerDTO;
import org.mapstruct.Mapper;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 22/02/2026
 */
@Mapper
public interface CustomerMapper {

  Customer customerDtoToCustomer(CustomerDTO customerDTO);

  CustomerDTO customerToCustomerDto(Customer customer);

}
