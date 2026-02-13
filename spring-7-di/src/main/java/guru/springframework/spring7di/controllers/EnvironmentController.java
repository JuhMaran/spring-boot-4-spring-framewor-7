package guru.springframework.spring7di.controllers;

import guru.springframework.spring7di.services.EnvironmentService;
import org.springframework.stereotype.Controller;

/**
 * spring-7-di
 *
 * @author Juliane Maran
 * @since 06/02/2026
 */
@Controller
public class EnvironmentController {

  private final EnvironmentService environmentService;

  public EnvironmentController(EnvironmentService environmentService) {
    this.environmentService = environmentService;
  }

  public String getEnvironment() {
    return "You are in " + environmentService.getEnv() + " Environment";
  }

}
