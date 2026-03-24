package guru.springframework.spring7restmvc.controller;

import guru.springframework.spring7restmvc.entities.BeerOrder;
import guru.springframework.spring7restmvc.model.BeerOrderCreateDTO;
import guru.springframework.spring7restmvc.model.BeerOrderDTO;
import guru.springframework.spring7restmvc.services.BeerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 24/03/2026
 */
@RestController
@RequiredArgsConstructor
public class BeerOrderController {

  public static final String BEER_ORDER_PATH = "/api/v1/beerorder";
  public static final String BEER_ORDER_PATH_ID = BEER_ORDER_PATH + "/{beerOrderId}";

  private final BeerOrderService beerOrderService;

  @PostMapping(BEER_ORDER_PATH)
  public ResponseEntity<Void> createOrder(@RequestBody BeerOrderCreateDTO beerOrderCreateDTO) {
    BeerOrder savedOrder = beerOrderService.createOrder(beerOrderCreateDTO);
    return ResponseEntity.created(URI.create(BEER_ORDER_PATH + "/" + savedOrder.getId().toString())).build();
  }

  @GetMapping(BEER_ORDER_PATH_ID)
  public BeerOrderDTO getBeerOrderById(@PathVariable UUID beerOrderId) {
    return beerOrderService.getById(beerOrderId).orElseThrow(NotFoundException::new);
  }

  @GetMapping(BEER_ORDER_PATH)
  public Page<BeerOrderDTO> listOrders(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                       @RequestParam(value = "pageSize", required = false) Integer pageSize) {
    return beerOrderService.listOrders(pageNumber, pageSize);
  }

}
