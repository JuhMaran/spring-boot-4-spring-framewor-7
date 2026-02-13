package guru.springframework.spring7di.services;

import org.springframework.stereotype.Service;

/**
 * spring-7-di
 *
 * @author Juliane Maran
 * @since 04/02/2026
 */
@Service
public class GreetingServiceImpl implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hello Everyone From Base Service!!!";
  }

}
