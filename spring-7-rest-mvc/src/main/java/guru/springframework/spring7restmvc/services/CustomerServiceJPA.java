package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.mappers.CustomerMapper;
import guru.springframework.spring7restmvc.model.CustomerDTO;
import guru.springframework.spring7restmvc.repositories.BeerRepository;
import guru.springframework.spring7restmvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * JPA Service
 *
 * @author Juliane Maran
 * @since 22/02/2026
 */
@Primary
@Service
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService {

  private final CustomerMapper customerMapper;
  private final CustomerRepository customerRepository;

  @Override
  public Optional<CustomerDTO> getCustomerById(UUID uuid) {
    return Optional.empty();
  }

  @Override
  public List<CustomerDTO> getAllCustomers() {
    return List.of();
  }

  @Override
  public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
    return null;
  }

  @Override
  public void updateCustomerById(UUID customerId, CustomerDTO customerDTO) {

  }

  @Override
  public void deleteCustomerById(UUID customerId) {

  }

  @Override
  public void patchCustomerById(UUID customerId, CustomerDTO customerDTO) {

  }

}
