package guru.springframework.juniemvc.services;

import guru.springframework.juniemvc.entities.Beer;

import java.util.List;
import java.util.Optional;

public interface BeerService {

    Beer saveBeer(Beer beer);

    Optional<Beer> findBeerById(Integer beerId);

    List<Beer> findAllBeers();
}
