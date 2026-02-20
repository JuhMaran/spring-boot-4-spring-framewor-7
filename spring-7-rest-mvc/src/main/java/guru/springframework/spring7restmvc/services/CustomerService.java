package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 10/02/2026
 */
public interface CustomerService {

  Optional<CustomerDTO> getCustomerById(UUID uuid);

  List<CustomerDTO> getAllCustomers();

  CustomerDTO saveNewCustomer(CustomerDTO customer);

  Optional<CustomerDTO> updateCustomerById(UUID customerId, CustomerDTO customer);

  Boolean deleteCustomerById(UUID customerId);

  Optional<CustomerDTO> patchCustomerById(UUID customerId, CustomerDTO customer);

}
