package guru.springframework.spring7restmvc.repositories;

import guru.springframework.spring7restmvc.bootstrap.BootstrapData;
import guru.springframework.spring7restmvc.entities.Beer;
import guru.springframework.spring7restmvc.services.BeerCsvServiceImpl;
import guru.springframework.spring7restmvcapi.model.BeerStyle;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@Import({BootstrapData.class, BeerCsvServiceImpl.class})
class BeerRepositoryTest {

  @Autowired
  BeerRepository beerRepository;

  @TestConfiguration
  static class TestConfig {
    @Bean
    public CacheManager cacheManager() {
      return new ConcurrentMapCacheManager();
    }
  }

  @Test
  void testGetBeerListByName() {
    Page<Beer> list = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%", null);
    assertThat(list.getContent().size()).isEqualTo(336);
  }

  @Test
  void testSaveBeerNameTooLong() {

    assertThrows(ConstraintViolationException.class, () -> {
      Beer savedBeer = beerRepository.save(Beer.builder()
        .beerName("My Beer 0123345678901233456789012334567890123345678901233456789012334567890123345678901233456789")
        .beerStyle(BeerStyle.PALE_ALE)
        .upc("234234234234")
        .price(new BigDecimal("11.99"))
        .build());

      beerRepository.flush();
    });
  }

  @Test
  void testSaveBeer() {
    Beer savedBeer = beerRepository.save(Beer.builder()
      .beerName("My Beer")
      .beerStyle(BeerStyle.PALE_ALE)
      .upc("234234234234")
      .price(new BigDecimal("11.99"))
      .build());

    beerRepository.flush();

    assertThat(savedBeer).isNotNull();
    assertThat(savedBeer.getId()).isNotNull();
  }
}