package guru.springframework.spring7di.controllers;

import guru.springframework.spring7di.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Injeção por Setter (Setter Injection)
 *
 * @author Juliane Maran
 * @since 04/02/2026
 */
@Controller
public class SetterInjectedController {

  private GreetingService greetingService;

  @Qualifier("setterGreetingBean")
  @Autowired
  public void setGreetingService(GreetingService greetingService) {
    System.out.println("SetterInjectedController.setGreetingService");
    this.greetingService = greetingService;
  }

  public String sayHello() {
    return greetingService.sayGreeting();
  }

}
