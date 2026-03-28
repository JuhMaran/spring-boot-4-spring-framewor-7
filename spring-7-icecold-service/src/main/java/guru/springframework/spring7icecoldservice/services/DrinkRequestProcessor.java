package guru.springframework.spring7icecoldservice.services;

import guru.springframework.spring7restmvcapi.events.DrinkRequestEvent;

/**
 * spring-7-icecold-service
 *
 * @author Juliane Maran
 * @since 28/03/2026
 */
public interface DrinkRequestProcessor {

  void processDrinkRequest(DrinkRequestEvent event);

}
