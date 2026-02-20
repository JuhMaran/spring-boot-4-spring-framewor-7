package guru.springframework.spring7restmvc.repositories;

import guru.springframework.spring7restmvc.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * O objetivo é testar EXCLUSIVAMENTE a camada de persistência com uma configuração mínima
 */
@DataJpaTest // Test Slice de JPA
class CustomerRepositoryTest {

  @Autowired
  CustomerRepository customerRepository;

  @Test
  void testSaveCustomer() {
    Customer customer = customerRepository.save(Customer.builder()
      .name("New Name")
      .build());

    assertThat(customer.getId()).isNotNull();

  }

}