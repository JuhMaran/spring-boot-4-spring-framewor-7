package guru.springframework.spring7reactivemongo.services;

import guru.springframework.spring7reactivemongo.model.CustomerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * spring-7-reactive-mongo
 *
 * @author Juliane Maran
 * @since 12/03/2026
 */
public interface CustomerService {

  Flux<CustomerDTO> listCustomers();

  Mono<CustomerDTO> getCustomerById(String customerId);

  Mono<CustomerDTO> saveNewCustomer(CustomerDTO customerDto);

  Mono<CustomerDTO> saveNewCustomer(Mono<CustomerDTO> customerDto);

  Mono<CustomerDTO> updateCustomer(String customerId, CustomerDTO customerDto);

  Mono<CustomerDTO> patchCustomer(String customerId, CustomerDTO customerDto);

  Mono<Void> deleteCustomerById(String customerId);

}
