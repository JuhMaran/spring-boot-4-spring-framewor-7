package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 21/02/2026
 */
public interface CustomerService {

  Optional<CustomerDTO> getCustomerById(UUID uuid);

  List<CustomerDTO> getAllCustomers();

  CustomerDTO saveNewCustomer(CustomerDTO customerDTO);

  void updateCustomerById(UUID customerId, CustomerDTO customerDTO);

  void deleteCustomerById(UUID customerId);

  void patchCustomerById(UUID customerId, CustomerDTO customerDTO);

}
