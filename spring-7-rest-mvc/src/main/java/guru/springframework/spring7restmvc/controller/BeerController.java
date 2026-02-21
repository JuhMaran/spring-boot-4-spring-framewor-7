package guru.springframework.spring7restmvc.controller;

import guru.springframework.spring7restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 21/02/2026
 */
@Controller
@AllArgsConstructor
public class BeerController {

  private final BeerService beerService;

}
