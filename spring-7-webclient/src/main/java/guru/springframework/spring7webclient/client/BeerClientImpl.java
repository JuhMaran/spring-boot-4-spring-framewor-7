package guru.springframework.spring7webclient.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * Client Implementation
 *
 * @author Juliane Maran
 * @since 14/03/2026
 */
@Service
public class BeerClientImpl implements BeerClient {

  private final WebClient webClient;

  public BeerClientImpl(WebClient.Builder builder) {
    this.webClient = builder
      .baseUrl("http://localhost:8080")
      .build();
  }

  @Override
  public Flux<String> listBeer() {
    return webClient.get()
      .uri("/api/v3/beer")
      .retrieve()
      .bodyToFlux(String.class);
  }

}
