package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.mappers.BeerMapper;
import guru.springframework.spring7restmvc.model.BeerDTO;
import guru.springframework.spring7restmvc.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * JPA Service
 *
 * @author Juliane Maran
 * @since 22/02/2026
 */
@Primary
@Service
@RequiredArgsConstructor
public class BeerServiceJPA implements BeerService {

  private final BeerMapper beerMapper;
  private final BeerRepository beerRepository;

  @Override
  public List<BeerDTO> listBeers() {
    return List.of();
  }

  @Override
  public Optional<BeerDTO> getBeerById(UUID id) {
    return Optional.empty();
  }

  @Override
  public BeerDTO saveNewBeer(BeerDTO beerDTO) {
    return null;
  }

  @Override
  public void updateBeerById(UUID beerId, BeerDTO beerDTO) {

  }

  @Override
  public void deleteById(UUID beerId) {

  }

  @Override
  public void patchBeerById(UUID beerId, BeerDTO beerDTO) {

  }

}
