package guru.springframework.spring7reactiveexample.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * spring-7-reactive
 *
 * @author Juliane Maran
 * @since 09/03/2026
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

  private Integer id;
  private String firstName;
  private String lastName;

}
