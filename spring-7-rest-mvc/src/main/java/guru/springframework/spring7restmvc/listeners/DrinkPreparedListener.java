package guru.springframework.spring7restmvc.listeners;

import guru.springframework.spring7restmvc.config.KafkaConfig;
import guru.springframework.spring7restmvc.repositories.BeerOrderLineRepository;
import guru.springframework.spring7restmvcapi.events.DrinkPreparedEvent;
import guru.springframework.spring7restmvcapi.model.BeerOrderLineStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 28/03/2026
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DrinkPreparedListener {

  private final BeerOrderLineRepository beerOrderLineRepository;

  @KafkaListener(groupId = "DrinkPreparedListener", topics = KafkaConfig.DRINK_PREPARED_TOPIC)
  public void listen(DrinkPreparedEvent event) {

    log.debug("Drink Prepared Event Received");

    beerOrderLineRepository.findById(event.getBeerOrderLine().getId()).ifPresentOrElse(beerOrderLine -> {

      beerOrderLine.setOrderLineStatus(BeerOrderLineStatus.COMPLETE);

      beerOrderLineRepository.save(beerOrderLine);
    }, () -> log.error("Beer Order Line Not Found!"));
  }

}
