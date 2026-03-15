package guru.springframework.spring7webclient.client;

import guru.springframework.spring7webclient.model.BeerDTO;
import reactor.core.publisher.Flux;
import tools.jackson.databind.JsonNode;

import java.util.Map;

/**
 * Beer Client
 *
 * @author Juliane Maran
 * @since 14/03/2026
 */
public interface BeerClient {

  Flux<String> listBeer();

  Flux<Map> listBeerMap();

  Flux<JsonNode> listBeersJsonNode();

  Flux<BeerDTO> listBeerDtos();

}
