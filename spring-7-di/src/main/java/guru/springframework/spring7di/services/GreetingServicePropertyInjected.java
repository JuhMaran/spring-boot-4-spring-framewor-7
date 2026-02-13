package guru.springframework.spring7di.services;

import org.springframework.stereotype.Service;

/**
 * spring-7-di
 *
 * @author Juliane Maran
 * @since 05/02/2026
 */
@Service("propertyGreetingService")
public class GreetingServicePropertyInjected implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Friends don't let friends to property injection!";
  }

}
