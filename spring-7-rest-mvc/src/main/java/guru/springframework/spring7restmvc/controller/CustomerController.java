package guru.springframework.spring7restmvc.controller;

import guru.springframework.spring7restmvc.model.Customer;
import guru.springframework.spring7restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 21/02/2026
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

  private final CustomerService customerService;

  @RequestMapping(method = RequestMethod.GET)
  public List<Customer> listAllCustomers() {
    return customerService.getAllCustomers();
  }

  @RequestMapping(method = RequestMethod.GET, value = "{customerId}")
  public Customer getCustomerById(@PathVariable("customerId") UUID id) {
    return customerService.getCustomerById(id);
  }

}
