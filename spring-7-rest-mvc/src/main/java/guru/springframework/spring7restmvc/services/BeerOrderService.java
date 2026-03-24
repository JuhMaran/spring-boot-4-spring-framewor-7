package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.entities.BeerOrder;
import guru.springframework.spring7restmvc.model.BeerOrderCreateDTO;
import guru.springframework.spring7restmvc.model.BeerOrderDTO;
import guru.springframework.spring7restmvc.model.BeerOrderUpdateDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

/**
 * Beer Order Service
 *
 * @author Juliane Maran
 * @since 24/03/2026
 */
public interface BeerOrderService {

  Optional<BeerOrderDTO> getById(UUID beerOrderId);

  Page<BeerOrderDTO> listOrders(Integer pageNumber, Integer pageSize);

  BeerOrder createOrder(BeerOrderCreateDTO beerOrderCreateDTO);

  BeerOrderDTO updateOrder(UUID beerOrderId, BeerOrderUpdateDTO beerOrderUpdateDTO);

  void deleteOrder(UUID beerOrderId);

}
