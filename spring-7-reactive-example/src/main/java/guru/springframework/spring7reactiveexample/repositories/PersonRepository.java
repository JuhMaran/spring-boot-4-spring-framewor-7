package guru.springframework.spring7reactiveexample.repositories;

import guru.springframework.spring7reactiveexample.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * spring-7-reactive
 *
 * @author Juliane Maran
 * @since 09/03/2026
 */
public interface PersonRepository {

  Mono<Person> getById(Integer id);

  Flux<Person> findAll();

}
