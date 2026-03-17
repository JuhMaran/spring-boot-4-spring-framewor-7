package guru.springframework.spring7restmvc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 16/03/2026
 */
@SpringBootTest
class debugOa3 {

  @Test
  void debugResource() {
    System.out.println(getClass().getResource("/oa3.yml"));
  }

}
