package guru.springframework.spring7di.controllers;

import guru.springframework.spring7di.services.GreetingService;
import guru.springframework.spring7di.services.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * spring-7-di
 *
 * @author Juliane Maran
 * @since 03/02/2026
 */
@Controller
public class MyController {

  private final GreetingService greetingService;

  @Autowired
  public MyController() {
    this.greetingService = new GreetingServiceImpl();
  }

  public String sayHello() {
    System.out.println("I'm in the controller");
    return greetingService.sayGreeting();
  }

  public void beforeInit() {
    System.out.println("## - Before Init - Called by Bean Post Processor");
  }

  public void afterInit() {
    System.out.println("## - After init called by Bean Post Processor");
  }

}
