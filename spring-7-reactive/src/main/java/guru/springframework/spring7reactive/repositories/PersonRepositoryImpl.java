package guru.springframework.spring7reactive.repositories;

import guru.springframework.spring7reactive.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * spring-7-reactive
 *
 * @author Juliane Maran
 * @since 09/03/2026
 */
public class PersonRepositoryImpl implements PersonRepository {

  Person michael = Person.builder().id(1).firstName("Michael").lastName("Weston").build();
  Person fiona = Person.builder().id(2).firstName("Fiona").lastName("Glenanne").build();
  Person sam = Person.builder().id(3).firstName("Sam").lastName("Axe").build();
  Person jesse = Person.builder().id(4).firstName("Jesse").lastName("Porter").build();

  @Override
  public Mono<Person> getById(final Integer id) {
    return findAll().filter(person -> person.getId().equals(id)).next();
//    return Mono.just(michael);
  }

  @Override
  public Flux<Person> findAll() {
    return Flux.just(michael, fiona, sam, jesse);
  }

}
