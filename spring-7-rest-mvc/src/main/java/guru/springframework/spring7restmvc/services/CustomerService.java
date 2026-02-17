package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.Customer;

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

  Optional<Customer> getCustomerById(UUID uuid);

  List<Customer> getAllCustomers();

  Customer saveNewCustomer(Customer customer);

  void updateCustomerById(UUID customerId, Customer customer);

  void deleteCustomerById(UUID customerId);

  void patchCustomerById(UUID customerId, Customer customer);

}
