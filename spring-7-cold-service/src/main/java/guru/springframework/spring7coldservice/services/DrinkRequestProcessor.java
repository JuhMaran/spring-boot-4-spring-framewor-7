package guru.springframework.spring7coldservice.services;

import guru.springframework.spring7restmvcapi.events.DrinkRequestEvent;

/**
 * spring-7-cold-service
 *
 * @author Juliane Maran
 * @since 28/03/2026
 */
public interface DrinkRequestProcessor {

  void processDrinkRequest(DrinkRequestEvent event);

}
