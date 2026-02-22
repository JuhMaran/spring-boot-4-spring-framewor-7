package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.mappers.CustomerMapper;
import guru.springframework.spring7restmvc.model.CustomerDTO;
import guru.springframework.spring7restmvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

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
  public Optional<CustomerDTO> getCustomerById(UUID id) {
    return Optional.ofNullable(customerMapper.customerToCustomerDto(customerRepository.findById(id)
      .orElse(null)));
  }

  @Override
  public List<CustomerDTO> getAllCustomers() {
    return customerRepository.findAll()
      .stream()
      .map(customerMapper::customerToCustomerDto)
      .toList();
  }

  @Override
  public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
    return customerMapper.customerToCustomerDto(customerRepository
      .save(customerMapper.customerDtoToCustomer(customerDTO)));
  }

  @Override
  public Optional<CustomerDTO> updateCustomerById(UUID customerId, CustomerDTO customerDTO) {
    AtomicReference<Optional<CustomerDTO>> atomicReference = new AtomicReference<>();

    customerRepository.findById(customerId).ifPresentOrElse(foundCustomer -> {
      foundCustomer.setName(customerDTO.getName());
      atomicReference.set(Optional.of(customerMapper
        .customerToCustomerDto(customerRepository.save(foundCustomer))));
    }, () -> atomicReference.set(Optional.empty()));

    return atomicReference.get();
  }

  @Override
  public Boolean deleteCustomerById(UUID customerId) {
    if (customerRepository.existsById(customerId)) {
      customerRepository.deleteById(customerId);
      return true;
    }
    return false;
  }

  @Override
  public Optional<CustomerDTO> patchCustomerById(UUID customerId, CustomerDTO customerDTO) {
    AtomicReference<Optional<CustomerDTO>> atomicReference = new AtomicReference<>();

    customerRepository.findById(customerId).ifPresentOrElse(foundCustomer -> {
      if (StringUtils.hasText(customerDTO.getName())) {
        foundCustomer.setName(customerDTO.getName());
      }
      atomicReference.set(Optional.of(customerMapper
        .customerToCustomerDto(customerRepository.save(foundCustomer))));
    }, () -> atomicReference.set(Optional.empty()));

    return atomicReference.get();
  }

}
