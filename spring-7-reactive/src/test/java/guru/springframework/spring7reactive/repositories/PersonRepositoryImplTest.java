package guru.springframework.spring7reactive.repositories;

import guru.springframework.spring7reactive.domain.Person;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

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

  // Operação bloqueante
  // Retorna apenas o primeiro elemento e bloqueia a execução.
  @Test
  void testFluxBlockFirst() {
    Flux<Person> personFlux = personRepository.findAll();

    Person person = personFlux.blockFirst();

    assert person != null;
    System.out.println(person);
  }

  // Processa todos os elementos do Flux de forma assíncrona e não bloqueante.
  @Test
  void testFluxSubscriber() {
    Flux<Person> personFlux = personRepository.findAll();

    personFlux.subscribe(System.out::println);
  }

  // Transformação com 'map' - Flux<Person> → Flux<String>
  @Test
  void testFluxMap() {
    Flux<Person> personFlux = personRepository.findAll();

    personFlux.map(Person::getFirstName).subscribe(System.out::println);
  }

  // Conversão para Lista - Flux<Person> → Mono<List<Person>>
  @Test
  void testFluxToList() {
    Flux<Person> personFlux = personRepository.findAll();

    Mono<List<Person>> listMono = personFlux.collectList();

    listMono.subscribe(list -> list
      .forEach(person -> System.out.println(person.getFirstName())));
  }

  @Test
  void testFilterOnName() {
    personRepository.findAll()
      .filter(person -> person.getFirstName().equals("Fiona"))
      .subscribe(person -> System.out.println(person.getLastName()));
  }

  @Test
  void testGetById() {
    Mono<Person> fionaMono = personRepository.findAll()
      .filter(person -> person.getFirstName().equals("Fiona"))
      .next();

    fionaMono.subscribe(person -> System.out.println(person.getFirstName()));
  }

}