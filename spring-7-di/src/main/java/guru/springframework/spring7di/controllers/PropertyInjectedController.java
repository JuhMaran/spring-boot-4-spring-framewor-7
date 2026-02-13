package guru.springframework.spring7di.controllers;

import guru.springframework.spring7di.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Property Injected (Injeção por Propriedade)
 *
 * @author Juliane Maran
 * @since 04/02/2026
 */
@Controller
public class PropertyInjectedController {

  @Qualifier("propertyGreetingService")
  @Autowired
  GreetingService greetingService;

  public String sayHello() {
    return greetingService.sayGreeting();
  }

}
