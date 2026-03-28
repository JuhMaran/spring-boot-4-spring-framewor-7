package guru.springframework.spring7restmvc.listeners;

import guru.springframework.spring7restmvc.config.KafkaConfig;
import guru.springframework.spring7restmvcapi.events.OrderPlacedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Event Listener
 *
 * @author Juliane Maran
 * @since 28/03/2026
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class OrderPlacedListener {

  private final KafkaTemplate<String, Object> kafkaTemplate;

  @Async
  @EventListener
  public void listen(OrderPlacedEvent event) {

    log.debug("Received OrderPlacedEvent {}", event);

    kafkaTemplate.send(KafkaConfig.ORDER_PLACED_TOPIC, event);

  }

}
