package guru.springframework.spring7restmvc.events;

import guru.springframework.spring7restmvc.entities.Beer;
import org.springframework.security.core.Authentication;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 23/03/2026
 */
public interface BeerEvent {

  Beer getBeer();

  Authentication getAuthentication();

}
