package guru.springframework.resttemplate.client;

import guru.springframework.resttemplate.model.BeerDTO;
import org.springframework.data.domain.Page;

/**
 * spring-7-resttemplate
 *
 * @author Juliane Maran
 * @since 02/03/2026
 */
public interface BeerClient {

  Page<BeerDTO> listBeers(String beerName);

}
