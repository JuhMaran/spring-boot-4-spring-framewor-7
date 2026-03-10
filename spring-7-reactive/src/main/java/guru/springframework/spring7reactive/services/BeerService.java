package guru.springframework.spring7reactive.services;

import guru.springframework.spring7reactive.model.BeerDTO;
import reactor.core.publisher.Flux;

/**
 * spring-7-reactive
 *
 * @author Juliane Maran
 * @since 10/03/2026
 */
public interface BeerService {

  Flux<BeerDTO> listBeers();

}
