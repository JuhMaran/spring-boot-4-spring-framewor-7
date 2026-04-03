package guru.springframework.kberestbrewery.domain;

import lombok.*;

import java.util.UUID;

/**
 * kbe-rest-brewery
 *
 * @author Juliane Maran
 * @since 03/04/2026
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

  private UUID id;
  private String name;

}
