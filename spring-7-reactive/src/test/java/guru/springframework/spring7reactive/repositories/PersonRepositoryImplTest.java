package guru.springframework.spring7reactive.repositories;

import guru.springframework.spring7reactive.domain.Person;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

class PersonRepositoryImplTest {

  PersonRepository personRepository = new PersonRepositoryImpl();

  // Operação Bloqueante - não recomendada em programação reativa
  @Test
  void testMonoByIdBlock() {
    Mono<Person> personMono = personRepository.getById(1);

    Person person = personMono.block();

    assert person != null;
    System.out.println(person);
  }

  // Uso de subscriber - forma não bloqueante e recomendada
  @Test
  void testGetByIdSubscriber() {
    Mono<Person> personMono = personRepository.getById(1);

    personMono.subscribe(System.out::println);
  }

  // Operação 'map' - Transforma o fluxo 'Mono<Person>' para 'Mono<String>'
  @Test
  void testMapOperation() {
    Mono<Person> personMono = personRepository.getById(1);

    personMono.map(Person::getFirstName).subscribe(System.out::println);

  }

}