package guru.springframework.spring7restmvcapi.events;

import guru.springframework.spring7restmvcapi.model.BeerOrderLineDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * spring-7-rest-mvc-api
 *
 * @author Juliane Maran
 * @since 28/03/2026
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DrinkRequestEvent {

  private BeerOrderLineDTO beerOrderLineDTO;

}
