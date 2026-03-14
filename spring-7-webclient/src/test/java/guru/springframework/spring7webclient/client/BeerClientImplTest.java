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
  void testListBeersMap() {
//    AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    client.listBeerMap().subscribe(response -> {
      System.out.println(response);
      atomicBoolean.set(true);
    });

    await().untilTrue(atomicBoolean);

//    try {
//      Thread.sleep(1000L);
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }

  }

  @Test
  void testListBeers() {
//    AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    client.listBeer().subscribe(response -> {
      System.out.println(response);
      atomicBoolean.set(true);
    });

    await().untilTrue(atomicBoolean);
//    try {
//      Thread.sleep(1000L);
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }
  }

}