package guru.springframework.lombokbestpractices.services;

import guru.springframework.lombokbestpractices.entities.BeerStyle;
import guru.springframework.lombokbestpractices.model.BeerDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

/**
 * lombok-best-practices
 *
 * @author Juliane Maran
 * @since 01/04/2026
 */
public interface BeerService {

  Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize);

  Optional<BeerDTO> getBeerById(UUID id);

  BeerDTO saveNewBeer(BeerDTO beer);

  Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);

  Boolean deleteById(UUID beerId);

  Optional<BeerDTO> patchBeerById(UUID beerId, BeerDTO beer);

}
