package guru.springframework.spring7webclient.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.awaitility.Awaitility.await;

@SpringBootTest
class BeerClientImplTest {

  @Autowired
  BeerClient client;

  AtomicBoolean atomicBoolean;

  @BeforeEach
  void setUp() {
    atomicBoolean = new AtomicBoolean(false);
  }

  @Test
  void testGetBeerByBeerStyle() {
    client.getBeerByBeerStyle("Pale Ale")
      .subscribe(dto -> {
        System.out.println(dto.toString());
        atomicBoolean.set(true);
      });

    await().untilTrue(atomicBoolean);
  }

  @Test
  void testGetBeerById() {
    client.listBeerDtos()
      .flatMap(dto -> client.getBeerById(dto.getId()))
      .subscribe(byIdDto -> {
        System.out.println(byIdDto.getBeerName());
        atomicBoolean.set(true);
      });

    await().untilTrue(atomicBoolean);
  }

  @Test
  void testGetBeerDto() {
    client.listBeerDtos().subscribe(dto -> {
      System.out.println(dto.getBeerName());
      atomicBoolean.set(true);
    });

    await().untilTrue(atomicBoolean);
  }

  @Test
  void testGetBeerJson() {
    client.listBeersJsonNode().subscribe(jsonNode -> {
      System.out.println(jsonNode.toPrettyString());
      atomicBoolean.set(true);
    });

    await().untilTrue(atomicBoolean);
  }

  @Test
  void testListBeerMap() {
    client.listBeerMap().subscribe(response -> {
      System.out.println(response);
      atomicBoolean.set(true);
    });

    await().untilTrue(atomicBoolean);
  }

  @Test
  void testListBeer() {
    client.listBeer().subscribe(response -> {
      System.out.println(response);
      atomicBoolean.set(true);
    });

    await().untilTrue(atomicBoolean);
  }

}