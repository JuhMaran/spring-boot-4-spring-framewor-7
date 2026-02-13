package guru.springframework.spring7di.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Service Primary
 *
 * @author Juliane Maran
 * @since 04/02/2026
 */
@Primary
@Service
public class GreetingServicePrimary implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hello From the Primary Bean!";
  }

}
