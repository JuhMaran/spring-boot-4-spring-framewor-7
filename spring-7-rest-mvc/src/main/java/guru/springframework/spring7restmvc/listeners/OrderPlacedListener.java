package guru.springframework.spring7restmvc.listeners;

import guru.springframework.spring7restmvcapi.events.OrderPlacedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 28/03/2026
 */
@Component
public class OrderPlacedListener {

  @Async
  @EventListener
  public void listen(OrderPlacedEvent event) {
    // todo add send to Kafka
    System.out.println("Order Placed Event Received");
  }

}
