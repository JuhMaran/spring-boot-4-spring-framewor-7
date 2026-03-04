package guru.springframework.resttemplate.client;

import guru.springframework.resttemplate.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BeerClientImplTest {

  @Autowired
  BeerClientImpl beerClient;

  @Test
  void getBeerById() {
    Page<BeerDTO> beerDTOS = beerClient.listBeers();

    BeerDTO beerDTO = beerDTOS.getContent().get(0);

    BeerDTO beerById = beerClient.getBeerById(beerDTO.getId());

    assertNotNull(beerById);
  }

  @Test
  void listBeersNoBeerName() {
    beerClient.listBeers(null, null, null, null, null);
  }

  @Test
  void listBeers() {
    beerClient.listBeers("ALE", null, null, null, null);
  }

}