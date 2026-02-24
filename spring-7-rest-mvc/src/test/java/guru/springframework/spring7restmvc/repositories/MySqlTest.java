package guru.springframework.spring7restmvc.repositories;

import guru.springframework.spring7restmvc.entities.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 24/02/2026
 */
@Testcontainers
@SpringBootTest
@ActiveProfiles("localmysql")
public class MySqlTest {

  @Container
  static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:9.2");

  @Autowired
  DataSource dataSource;

  @Autowired
  BeerRepository beerRepository;

  @DynamicPropertySource
  static void mySqlProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.username", mySQLContainer::getUsername);
    registry.add("spring.datasource.password", mySQLContainer::getPassword);
    registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
  }

  @Test
  void testListBeers() {
    List<Beer> beers = beerRepository.findAll();
    assertThat(beers.size()).isGreaterThan(0);
  }
}
