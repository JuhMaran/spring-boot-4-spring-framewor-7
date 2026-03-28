package guru.springframework.spring7coldservice.listeners;

import guru.springframework.spring7coldservice.config.KafkaConfig;
import guru.springframework.spring7restmvcapi.events.DrinkPreparedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * spring-7-cold-service
 *
 * @author Juliane Maran
 * @since 28/03/2026
 */
@Component
public class DrinkPreparedListener {

  public AtomicInteger iceColdMessageCounter = new AtomicInteger(0);

  @KafkaListener(topics = KafkaConfig.DRINK_PREPARED_TOPIC, groupId = "cold-listener")
  public void listen(DrinkPreparedEvent event) {
    System.out.println("I'm listening...");

    iceColdMessageCounter.incrementAndGet();
  }

}
