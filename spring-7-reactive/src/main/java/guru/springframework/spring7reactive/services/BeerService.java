package guru.springframework.spring7reactive.services;

import guru.springframework.spring7reactive.model.BeerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * spring-7-reactive
 *
 * @author Juliane Maran
 * @since 10/03/2026
 */
public interface BeerService {

  Flux<BeerDTO> listBeers();

  Mono<BeerDTO> getBeerById(Integer beerId);

  Mono<BeerDTO> saveNewBeer(BeerDTO beerDTO);

  Mono<BeerDTO> updateBeer(Integer beerId, BeerDTO beerDTO);

  Mono<BeerDTO> patchBeer(Integer beerId, BeerDTO beerDTO);
  
}
