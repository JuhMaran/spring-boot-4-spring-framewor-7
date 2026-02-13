package guru.springframework.spring7restmvc.controller;

import guru.springframework.spring7restmvc.model.Beer;
import guru.springframework.spring7restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 08/02/2026
 */
@Slf4j
@Controller
@AllArgsConstructor
public class BeerController {

  private final BeerService beerService;

  public Beer getBeerById(UUID id) {
    log.debug("Get Beer by Id - in controller");
    return beerService.getBeerById(id);
  }

}
