package guru.springframework.spring7reactivemongo.services;

import guru.springframework.spring7reactivemongo.model.BeerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * spring-7-reactive-mongo
 *
 * @author Juliane Maran
 * @since 12/03/2026
 */
public interface BeerService {

  Flux<BeerDTO> listBeers();

  Mono<BeerDTO> saveBeer(Mono<BeerDTO> beerDto);

  Mono<BeerDTO> saveBeer(BeerDTO beerDTO);

  Mono<BeerDTO> getById(String beerId);

  Mono<BeerDTO> updateBeer(String beerId, BeerDTO beerDTO);

  Mono<BeerDTO> patchBeer(String beerId, BeerDTO beerDTO);

  Mono<Void> deleteBeerById(String beerId);

}
