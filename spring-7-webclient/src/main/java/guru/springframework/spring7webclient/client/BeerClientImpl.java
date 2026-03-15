package guru.springframework.spring7webclient.client;

import guru.springframework.spring7webclient.model.BeerDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tools.jackson.databind.JsonNode;

import java.util.Map;

/**
 * Client Implementation
 *
 * @author Juliane Maran
 * @since 14/03/2026
 */
@Service
public class BeerClientImpl implements BeerClient {

  private final WebClient webClient;
  public static final String BEER_PATH = "/api/v3/beer";
  public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";

  // Spring Boot auto-configures a WebClient.Builder instance with nice defaults and customizations.
  // We can use it to create a dedicated WebClient for our component.
  public BeerClientImpl(WebClient.Builder builder) {
    this.webClient = builder
      .baseUrl("http://localhost:8080")
      .build();
  }

  @Override
  public Mono<BeerDTO> getBeerById(String id) {
    return webClient.get()
      .uri(uriBuilder -> uriBuilder.path(BEER_PATH_ID)
        .build(id))
      .retrieve().bodyToMono(BeerDTO.class);
  }

  @Override
  public Flux<BeerDTO> listBeerDtos() {
    return webClient.get().uri(BEER_PATH)
      .retrieve().bodyToFlux(BeerDTO.class);
  }

  @Override
  public Flux<JsonNode> listBeersJsonNode() {
    return webClient.get().uri(BEER_PATH)
      .retrieve().bodyToFlux(JsonNode.class);
  }

  @Override
  public Flux<Map> listBeerMap() {
    return webClient.get().uri(BEER_PATH)
      .retrieve().bodyToFlux(Map.class);
  }

  @Override
  public Flux<String> listBeer() {
    return webClient.get().uri(BEER_PATH)
      .retrieve().bodyToFlux(String.class);
  }

}
