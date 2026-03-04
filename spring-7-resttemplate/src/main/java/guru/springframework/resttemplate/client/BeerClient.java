package guru.springframework.resttemplate.client;

import guru.springframework.resttemplate.model.BeerDTO;
import guru.springframework.resttemplate.model.BeerStyle;
import org.springframework.data.domain.Page;

import java.util.UUID;

/**
 * spring-7-resttemplate
 *
 * @author Juliane Maran
 * @since 02/03/2026
 */
public interface BeerClient {

  Page<BeerDTO> listBeers();

  Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber,
                          Integer pageSize);

  BeerDTO getBeerById(UUID beerId);

  BeerDTO createBeer(BeerDTO newDto);

  BeerDTO updateBeer(BeerDTO beerDto);

  void deleteBeer(UUID beerId);

}
