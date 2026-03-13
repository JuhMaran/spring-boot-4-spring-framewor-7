package guru.springframework.spring7reactivemongo.services;

import guru.springframework.spring7reactivemongo.model.BeerDTO;
import reactor.core.publisher.Mono;

/**
 * spring-7-reactive-mongo
 *
 * @author Juliane Maran
 * @since 12/03/2026
 */
public interface BeerService {

  Mono<BeerDTO> saveBeer(Mono<BeerDTO> beerDTO);

  Mono<BeerDTO> getById(String beerId);

}
