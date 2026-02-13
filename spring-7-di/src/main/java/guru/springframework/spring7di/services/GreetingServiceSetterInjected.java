package guru.springframework.spring7di.services;

import org.springframework.stereotype.Service;

/**
 * spring-7-di
 *
 * @author Juliane Maran
 * @since 05/02/2026
 */
@Service("setterGreetingBean")
public class GreetingServiceSetterInjected implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hey I'm Setting a Greeting";
  }

}
