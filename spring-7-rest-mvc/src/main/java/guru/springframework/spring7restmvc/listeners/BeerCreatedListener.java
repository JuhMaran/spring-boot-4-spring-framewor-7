package guru.springframework.spring7restmvc.listeners;

import guru.springframework.spring7restmvc.events.BeerCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 22/03/2026
 */
@Component
public class BeerCreatedListener {

  @Async
  @EventListener
  public void listen(BeerCreatedEvent event) {
    System.out.println("I heard a beer was created!");
    System.out.println(event.getBeer().getId());

    System.out.println("Current Thread Name: " + Thread.currentThread().getName());
    System.out.println("Current Thread ID: " + Thread.currentThread().getId());

    //todo impl - add real implementation to persist audit record
  }

}
