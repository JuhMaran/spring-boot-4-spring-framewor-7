package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.BeerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 21/02/2026
 */
public interface BeerService {

  List<BeerDTO> listBeers();

  Optional<BeerDTO> getBeerById(UUID id);

  BeerDTO saveNewBeer(BeerDTO beerDTO);

  Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beerDTO);

  void deleteById(UUID beerId);

  void patchBeerById(UUID beerId, BeerDTO beerDTO);

}
