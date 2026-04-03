package guru.springframework.kberestbrewery.services;

import guru.springframework.kberestbrewery.mappers.CustomerMapper;
import guru.springframework.kberestbrewery.model.CustomerDto;
import guru.springframework.kberestbrewery.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * kbe-rest-brewery
 *
 * @author Juliane Maran
 * @since 03/04/2026
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  @Override
  public CustomerDto getCustomerById(UUID customerId) {
    return CustomerDto.builder()
      .id(UUID.randomUUID())
      .name("Joe Buck")
      .build();
  }

  @Override
  public CustomerDto saveNewCustomer(CustomerDto customerDto) {
    return CustomerDto.builder()
      .id(UUID.randomUUID())
      .build();
  }

  @Override
  public void updateCustomer(UUID customerId, CustomerDto customerDto) {
    //todo impl
    log.debug("Updating....");
  }

  @Override
  public void deleteById(UUID customerId) {
    //todo impl
    log.debug("Deleting.... ");
  }

}
