package guru.springframework.spring7restmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 24/03/2026
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class BeerOrderController {

  public static final String BEER_ORDER_PATH = "/api/v1/beerorder";
  public static final String BEER_ORDER_PATH_ID = BEER_ORDER_PATH + "/{beerOrderId}";



}
