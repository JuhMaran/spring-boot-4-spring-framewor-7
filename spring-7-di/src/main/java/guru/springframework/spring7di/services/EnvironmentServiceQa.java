package guru.springframework.spring7di.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * spring-7-di
 *
 * @author Juliane Maran
 * @since 06/02/2026
 */
@Profile("qa")
@Service
public class EnvironmentServiceQa implements EnvironmentService {

  @Override
  public String getEnv() {
    return "qa";
  }

}
