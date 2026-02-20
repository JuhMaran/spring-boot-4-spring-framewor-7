package guru.springframework.spring7restmvc.mappers;

import guru.springframework.spring7restmvc.entities.Customer;
import guru.springframework.spring7restmvc.model.CustomerDTO;
import org.mapstruct.Mapper;

/**
 * O MapStruct gerará automaticamente classes de mapeamento
 *
 * @author Juliane Maran
 * @since 18/02/2026
 */
@Mapper
public interface CustomerMapper {

  Customer customerDtoToCustomer(CustomerDTO dto);

  CustomerDTO customerToCustomerDto(Customer customer);

}
