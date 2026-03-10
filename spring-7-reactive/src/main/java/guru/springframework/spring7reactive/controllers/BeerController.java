package guru.springframework.spring7reactive.controllers;

import guru.springframework.spring7reactive.model.BeerDTO;
import guru.springframework.spring7reactive.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
  public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";

  private final BeerService beerService;

  @PutMapping(BEER_PATH_ID)
  Mono<ResponseEntity<Void>> updateExistingBeer(@PathVariable("beerId") Integer beerId,
                                                @RequestBody BeerDTO beerDTO){
    return beerService.updateBeer(beerId, beerDTO)
      .map(savedDto -> ResponseEntity.ok().build());
  }

  @PostMapping(BEER_PATH)
  Mono<ResponseEntity<Void>> createNewBeer(@RequestBody BeerDTO beerDTO) {
    return beerService.saveNewBeer(beerDTO)
      .map(savedDto -> ResponseEntity.created(UriComponentsBuilder
          .fromUriString("http://localhost:8080/" + BEER_PATH + "/" + savedDto.getId())
          .build().toUri())
        .build());
  }

  @GetMapping(BEER_PATH_ID)
  Mono<BeerDTO> getBeerById(@PathVariable("beerId") Integer beerId) {
    return beerService.getBeerById(beerId);
  }

  @GetMapping(BEER_PATH)
  Flux<BeerDTO> listBeers() {
    return beerService.listBeers();
  }

}
