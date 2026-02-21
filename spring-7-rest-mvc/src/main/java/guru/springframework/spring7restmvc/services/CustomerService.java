package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 21/02/2026
 */
public interface CustomerService {

  Customer getCustomerById(UUID uuid);

  List<Customer> getAllCustomers();

  Customer saveNewCustomer(Customer customer);

}
