package guru.springframework.spring7restmvc.events;

import guru.springframework.spring7restmvc.entities.Beer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 22/03/2026
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class BeerDeletedEvent implements BeerEvent {

  private Beer beer;
  private Authentication authentication;

}
