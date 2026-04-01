package guru.springframework.lombokbestpractices.services;

import guru.springframework.lombokbestpractices.entities.BeerOrder;
import guru.springframework.lombokbestpractices.model.BeerOrderCreateDTO;
import guru.springframework.lombokbestpractices.model.BeerOrderDTO;
import guru.springframework.lombokbestpractices.model.BeerOrderUpdateDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

/**
 * lombok-best-practices
 *
 * @author Juliane Maran
 * @since 01/04/2026
 */
public interface BeerOrderService {

  Optional<BeerOrderDTO> getById(UUID beerOrderId);

  Page<BeerOrderDTO> listOrders(Integer pageNumber, Integer pageSize);

  BeerOrder createOrder(BeerOrderCreateDTO beerOrderCreateDTO);

  BeerOrderDTO updateOrder(UUID beerOrderId, BeerOrderUpdateDTO beerOrderUpdateDTO);

  void deleteOrder(UUID beerOrderId);

}
