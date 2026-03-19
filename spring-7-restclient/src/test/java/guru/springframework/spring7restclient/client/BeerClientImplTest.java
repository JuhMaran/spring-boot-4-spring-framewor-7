package guru.springframework.spring7restclient.client;

import guru.springframework.spring7restclient.model.BeerDTO;
import guru.springframework.spring7restclient.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientImplTest {

  @Autowired
  BeerClientImpl beerClient;

  @Test
  void listBeers() {
    beerClient.listBeers("ALE", null, null, null, null);
  }

  @Test
  void testListBeers() {
    beerClient.listBeers(null, null, null, null, null);
  }

  @Test
  void getBeerById() {
    Page<BeerDTO> beerDTOS = beerClient.listBeers();

    BeerDTO dto = beerDTOS.getContent().getFirst(); // line 35

    BeerDTO byId = beerClient.getBeerById(dto.getId());

    assertNotNull(byId);
  }

  @Test
  void createBeer() {
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
  void updateBeer() {
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
  void deleteBeer() {
    BeerDTO newDto = BeerDTO.builder()
      .price(new BigDecimal("10.99"))
      .beerName("Mango Bobs 2")
      .beerStyle(BeerStyle.IPA)
      .quantityOnHand(500)
      .upc("123245")
      .build();

    BeerDTO beerDto = beerClient.createBeer(newDto);

    beerClient.deleteBeer(beerDto.getId());

    assertThrows(HttpClientErrorException.class, () -> {
      //should error
      beerClient.getBeerById(beerDto.getId());
    });
  }

}