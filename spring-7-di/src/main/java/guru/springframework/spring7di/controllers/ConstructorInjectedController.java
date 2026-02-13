package guru.springframework.spring7di.controllers;

import guru.springframework.spring7di.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Injeção por Construtor (Constructor Injection)
 *
 * @author Juliane Maran
 * @since 04/02/2026
 */
@Controller
public class ConstructorInjectedController {

  private final GreetingService greetingService;

  public ConstructorInjectedController(@Qualifier("greetingServiceImpl") GreetingService greetingService) {
    this.greetingService = greetingService;
  }

//  public ConstructorInjectedController(GreetingService greetingService) {
//    this.greetingService = greetingService;
//  }

  public String sayHello() {
    return greetingService.sayGreeting();
  }

}
