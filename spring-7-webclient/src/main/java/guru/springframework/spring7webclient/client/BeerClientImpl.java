package guru.springframework.spring7webclient.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

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
  public static final String BEER_PATH_ID = BEER_PATH + "/api/v3/beer";

  public BeerClientImpl(WebClient.Builder builder) {
    this.webClient = builder
      .baseUrl("http://localhost:8080")
      .build();
  }

  @Override
  public Flux<Map> listBeerMap() {
    return webClient.get()
      .uri(BEER_PATH, Map.class)
      .retrieve()
      .bodyToFlux(Map.class);
  }

  @Override
  public Flux<String> listBeer() {
    return webClient.get()
      .uri(BEER_PATH)
      .retrieve()
      .bodyToFlux(String.class);
  }

}
