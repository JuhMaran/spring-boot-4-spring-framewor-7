package guru.springframework.spring7coolservice.services;

import guru.springframework.spring7restmvcapi.events.DrinkRequestEvent;

/**
 * spring-7-cool-service
 *
 * @author Juliane Maran
 * @since 28/03/2026
 */
public interface DrinkRequestProcessor {

  void processDrinkRequest(DrinkRequestEvent event);

}
