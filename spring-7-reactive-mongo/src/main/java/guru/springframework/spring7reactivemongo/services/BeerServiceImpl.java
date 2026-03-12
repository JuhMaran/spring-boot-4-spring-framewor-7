package guru.springframework.spring7reactivemongo.services;

import guru.springframework.spring7reactivemongo.mappers.BeerMapper;
import guru.springframework.spring7reactivemongo.model.BeerDTO;
import guru.springframework.spring7reactivemongo.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * spring-7-reactive-mongo
 *
 * @author Juliane Maran
 * @since 12/03/2026
 */
@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

  private final BeerMapper beerMapper;
  private final BeerRepository beerRepository;

  @Override
  public Mono<BeerDTO> saveBeer(BeerDTO beerDTO) {
    return null;
  }

  @Override
  public Mono<BeerDTO> getById(String beerId) {
    return null;
  }

}
