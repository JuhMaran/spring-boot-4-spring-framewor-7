package guru.springframework.spring7di.controllers.i18n;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// @ActiveProfiles("EN")
@SpringBootTest
class Myi18NControllerTestEN {

  @Autowired
  Myi18NController myi18NController;

  @Test
  void sayHello() {

    System.out.println(myi18NController.sayHello());
  }

}