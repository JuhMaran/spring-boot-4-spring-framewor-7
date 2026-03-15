package guru.springframework.spring7webclient.client;

import guru.springframework.spring7webclient.model.BeerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
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

  Mono<BeerDTO> getBeerById(String id);

  Flux<BeerDTO> getBeerByBeerStyle(String beerStyle);

  Mono<BeerDTO> createBeer(BeerDTO beerDTO);

}
