package guru.springframework.spring7di.services.i18n;

import guru.springframework.spring7di.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * spring-7-di
 *
 * @author Juliane Maran
 * @since 06/02/2026
 */
//@Profile("EN")
@Service("i18NService")
public class EnglishGreetingService implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hello World - EN";
  }

}
