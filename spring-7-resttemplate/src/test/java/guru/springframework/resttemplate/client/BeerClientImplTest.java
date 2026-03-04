package guru.springframework.resttemplate.client;

import guru.springframework.resttemplate.model.BeerDTO;
import guru.springframework.resttemplate.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BeerClientImplTest {

  @Autowired
  BeerClientImpl beerClient;

  @Test
  void testUpdateBeer() {
    BeerDTO newDto = BeerDTO.builder()
      .price(new BigDecimal("10.99"))
      .beerName("Mango Bobs 2")
      .beerStyle(BeerStyle.IPA)
      .quantityOnHand(500)
      .upc("123245")
      .build();

    BeerDTO beerDto = beerClient.createBeer(newDto);

    final String newName = "Mango Bobs 3";
    beerDto.setBeerName(newName);
    BeerDTO updatedBeer = beerClient.updateBeer(beerDto);

    assertEquals(newName, updatedBeer.getBeerName());
  }

  @Test
  void testCreateBeer() {
    BeerDTO newDto = BeerDTO.builder()
      .price(new BigDecimal("10.99"))
      .beerName("Mango Bobs")
      .beerStyle(BeerStyle.IPA)
      .quantityOnHand(500)
      .upc("12345")
      .build();

    BeerDTO savedDto = beerClient.createBeer(newDto);
    assertNotNull(savedDto);
  }

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