package guru.springframework.spring7reactivemongo.services;

import guru.springframework.spring7reactivemongo.mappers.CustomerMapper;
import guru.springframework.spring7reactivemongo.model.CustomerDTO;
import guru.springframework.spring7reactivemongo.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * spring-7-reactive-mongo
 *
 * @author Juliane Maran
 * @since 14/03/2026
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerMapper customerMapper;
  private final CustomerRepository customerRepository;

  @Override
  public Flux<CustomerDTO> listCustomers() {
    return customerRepository.findAll()
      .map(customerMapper::customerToCustomerDto);
  }

  @Override
  public Mono<CustomerDTO> getCustomerById(String customerId) {
    return customerRepository.findById(customerId)
      .map(customerMapper::customerToCustomerDto);
  }

  @Override
  public Mono<CustomerDTO> saveNewCustomer(CustomerDTO customerDto) {
    return customerRepository.save(customerMapper.customerDtoToCustomer(customerDto))
      .map(customerMapper::customerToCustomerDto);
  }

  @Override
  public Mono<CustomerDTO> saveNewCustomer(Mono<CustomerDTO> customerDto) {
    return customerDto.map(customerMapper::customerDtoToCustomer)
      .flatMap(customerRepository::save)
      .map(customerMapper::customerToCustomerDto);
  }

  @Override
  public Mono<CustomerDTO> updateCustomer(String customerId, CustomerDTO customerDto) {
    return customerRepository.findById(customerId)
      .map(customer -> {
        customer.setCustomerName(customerDto.getCustomerName());
        return customer;
      }).flatMap(customerRepository::save)
      .map(customerMapper::customerToCustomerDto);
  }

  @Override
  public Mono<CustomerDTO> patchCustomer(String customerId, CustomerDTO customerDto) {
    return customerRepository.findById(customerId)
      .map(customer -> {
        if (StringUtils.hasText(customerDto.getCustomerName())) {
          customer.setCustomerName(customerDto.getCustomerName());
        }
        return customer;
      }).flatMap(customerRepository::save)
      .map(customerMapper::customerToCustomerDto);
  }

  @Override
  public Mono<Void> deleteCustomerById(String customerId) {
    return customerRepository.deleteById(customerId);
  }

}
