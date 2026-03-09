package guru.springframework.spring7reactive.repositories;

import guru.springframework.spring7reactive.domain.Beer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * spring-7-reactive
 *
 * @author Juliane Maran
 * @since 09/03/2026
 */
public interface BeerRepository extends ReactiveCrudRepository<Beer, Integer> {

}
