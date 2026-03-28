package guru.springframework.spring7coldservice.listeners;

import guru.springframework.spring7coldservice.config.KafkaConfig;
import guru.springframework.spring7coldservice.services.DrinkRequestProcessor;
import guru.springframework.spring7restmvcapi.events.DrinkPreparedEvent;
import guru.springframework.spring7restmvcapi.events.DrinkRequestEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * spring-7-cold-service
 *
 * @author Juliane Maran
 * @since 28/03/2026
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DrinkRequestListener {

  private final DrinkRequestProcessor drinkRequestProcessor;
  private final KafkaTemplate<String, Object> kafkaTemplate;

  @KafkaListener(groupId = "ColdListener", topics = KafkaConfig.DRINK_REQUEST_COLD_TOPIC)
  public void listenDrinkRequest(DrinkRequestEvent event) {
    log.debug("I am listening - drink request");

    drinkRequestProcessor.processDrinkRequest(event);

    kafkaTemplate.send(KafkaConfig.DRINK_PREPARED_TOPIC, DrinkPreparedEvent.builder()
      .beerOrderLine(event.getBeerOrderLineDTO())
      .build());

  }

}
