package guru.springframework.spring7di.controllers.i18n;

import guru.springframework.spring7di.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * spring-7-di
 *
 * @author Juliane Maran
 * @since 06/02/2026
 */
@Controller
public class Myi18NController {

  private final GreetingService greetingService;

  public Myi18NController(@Qualifier("i18NService") GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public String sayHello(){
    return greetingService.sayGreeting();
  }

}
