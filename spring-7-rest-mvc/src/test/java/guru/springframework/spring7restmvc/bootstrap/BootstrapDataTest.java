package guru.springframework.spring7restmvc.bootstrap;

import guru.springframework.spring7restmvc.repositories.BeerRepository;
import guru.springframework.spring7restmvc.repositories.CustomerRepository;
import guru.springframework.spring7restmvc.services.BeerCsvService;
import guru.springframework.spring7restmvc.services.BeerCsvServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(BeerCsvServiceImpl.class)
class BootstrapDataTest {

  @Autowired
  BeerRepository beerRepository;

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  BeerCsvService csvService;

  BootstrapData bootstrapData;

  @BeforeEach
  void setUp() {
    bootstrapData = new BootstrapData(beerRepository, customerRepository, csvService);
  }

  @TestConfiguration
  static class TestConfig {
    @Bean
    public CacheManager cacheManager() {
      return new ConcurrentMapCacheManager();
    }
  }

  @Test
  void testRun() throws Exception {
    bootstrapData.run(null);

    assertThat(beerRepository.count()).isEqualTo(2413);
    assertThat(customerRepository.count()).isEqualTo(3);
  }

}