package guru.springframework.kberestbrewery.services;

import guru.springframework.kberestbrewery.model.BeerStyleEnum;
import guru.springframework.kberestbrewery.model.BeerDto;
import guru.springframework.kberestbrewery.model.BeerPagedList;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

/**
 * kbe-rest-brewery
 *
 * @author Juliane Maran
 * @since 03/04/2026
 */
public interface BeerService {

  BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

  BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

  BeerDto saveNewBeer(BeerDto beerDto);

  BeerDto updateBeer(UUID beerId, BeerDto beerDto);

  BeerDto getByUpc(String upc);

  void deleteBeerById(UUID beerId);
}
