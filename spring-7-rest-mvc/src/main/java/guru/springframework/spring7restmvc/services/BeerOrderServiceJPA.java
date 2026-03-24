package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.mappers.BeerOrderMapper;
import guru.springframework.spring7restmvc.model.BeerOrderDTO;
import guru.springframework.spring7restmvc.repositories.BeerOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Beer Order Service JPA
 *
 * @author Juliane Maran
 * @since 24/03/2026
 */
@Service
@RequiredArgsConstructor
public class BeerOrderServiceJPA implements BeerOrderService {

  private final BeerOrderMapper beerOrderMapper;
  private final BeerOrderRepository beerOrderRepository;

  @Override
  public Optional<BeerOrderDTO> getById(UUID beerOrderId) {
    return Optional.ofNullable(beerOrderMapper.beerOrderToBeerOrderDto(beerOrderRepository.findById(beerOrderId)
      .orElse(null)));
  }

  @Override
  public Page<BeerOrderDTO> listOrders(Integer pageNumber, Integer pageSize) {

    if (pageNumber == null || pageNumber < 0) {
      pageNumber = 0;
    }
    if (pageSize == null || pageSize < 1) {
      pageSize = 25;
    }
    PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

    return beerOrderRepository.findAll(pageRequest).map(beerOrderMapper::beerOrderToBeerOrderDto);

  }

}
