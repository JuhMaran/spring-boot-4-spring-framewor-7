package guru.springframework.spring7reactivemongo.web.fn;

import guru.springframework.spring7reactivemongo.model.BeerDTO;
import guru.springframework.spring7reactivemongo.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * spring-7-reactive-mongo
 *
 * @author Juliane Maran
 * @since 13/03/2026
 */
@Component
@RequiredArgsConstructor
public class BeerHandler {

  private final BeerService beerService;

  public Mono<ServerResponse> getBeerById(ServerRequest request) {
    return ServerResponse.ok()
      .body(beerService.getById(request.pathVariable("beerId")), BeerDTO.class);
  }

  public Mono<ServerResponse> listBeers(ServerRequest request) {
    return ServerResponse.ok()
      .body(beerService.listBeers(), BeerDTO.class);
  }

}
