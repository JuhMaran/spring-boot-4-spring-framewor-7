package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.BeerOrderDTO;
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

}
