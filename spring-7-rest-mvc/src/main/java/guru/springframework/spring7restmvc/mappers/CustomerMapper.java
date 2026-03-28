package guru.springframework.spring7restmvc.mappers;

import guru.springframework.spring7restmvc.entities.Customer;
import guru.springframework.spring7restmvcapi.model.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 22/02/2026
 */
@Mapper
public interface CustomerMapper {


  @Mapping(target = "beerOrders", ignore = true)
  Customer customerDtoToCustomer(CustomerDTO customerDTO);

  CustomerDTO customerToCustomerDto(Customer customer);

}
