package guru.springframework.spring7webclient.client;

import reactor.core.publisher.Flux;

/**
 * Beer Client
 *
 * @author Juliane Maran
 * @since 14/03/2026
 */
public interface BeerClient {

  Flux<String> listBeer();

}
