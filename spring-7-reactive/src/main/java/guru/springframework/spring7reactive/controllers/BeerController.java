package guru.springframework.spring7reactive.controllers;

import guru.springframework.spring7reactive.model.BeerDTO;
import guru.springframework.spring7reactive.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Controller WebFlux
 *
 * @author Juliane Maran
 * @since 09/03/2026
 */
@RestController
@RequiredArgsConstructor
public class BeerController {

  public static final String BEER_PATH = "/api/v2/beer";

  private final BeerService beerService;

  @GetMapping(BEER_PATH)
  Flux<BeerDTO> listBeers() {
    return beerService.listBeers();
//    return Flux.just(BeerDTO.builder().id(1).build(),
//      BeerDTO.builder().id(2).build());
  }

}
