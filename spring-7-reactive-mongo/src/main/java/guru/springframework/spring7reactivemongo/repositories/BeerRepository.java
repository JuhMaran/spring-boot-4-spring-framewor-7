package guru.springframework.spring7reactivemongo.repositories;

import guru.springframework.spring7reactivemongo.domain.Beer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * spring-7-reactive-mongo
 *
 * @author Juliane Maran
 * @since 12/03/2026
 */
public interface BeerRepository extends ReactiveMongoRepository<Beer, String> {

  Mono<Beer> findFirstByBeerName(String beerName);

  Flux<Beer> findByBeerStyle(String beerStyle);

}
