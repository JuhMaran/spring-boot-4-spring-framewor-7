package guru.springframework.spring7restmvc.controller;

import guru.springframework.spring7restmvc.model.Beer;
import guru.springframework.spring7restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 21/02/2026
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/beer")
public class BeerController {

  private final BeerService beerService;

  @PostMapping
//  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity handlePost(@RequestBody Beer beer) { // Raw use of parameterized class 'ResponseEntity'
    Beer savedBeer = beerService.saveNewBeer(beer);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());

    return new ResponseEntity(headers, HttpStatus.CREATED); // Raw use of parameterized class 'ResponseEntity' 
  }

  // Replace "@RequestMapping(method = RequestMethod.GET)" with "@GetMapping"
  @RequestMapping(method = RequestMethod.GET)
  public List<Beer> listBeers() {
    return beerService.listBeers();
  }

  // Replace "@RequestMapping(method = RequestMethod.GET)" with "@GetMapping"
  @RequestMapping(method = RequestMethod.GET, value = "{beerId}")
  public Beer getBeerById(@PathVariable("beerId") UUID beerId) {
    log.debug("Get Beer by Id - in controller");
    return beerService.getBeerById(beerId);
  }

}
