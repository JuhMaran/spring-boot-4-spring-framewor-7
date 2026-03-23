package guru.springframework.spring7restmvc.repositories;

import guru.springframework.spring7restmvc.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomerRepositoryTest {

  @Autowired
  CustomerRepository customerRepository;

  @TestConfiguration
  static class TestConfig {
    @Bean
    public CacheManager cacheManager() {
      return new ConcurrentMapCacheManager();
    }
  }

  @Test
  void testSaveCustomer() {
    Customer customer = customerRepository.save(Customer.builder()
      .name("New Name")
      .build());
    assertThat(customer.getId()).isNotNull();
  }

}