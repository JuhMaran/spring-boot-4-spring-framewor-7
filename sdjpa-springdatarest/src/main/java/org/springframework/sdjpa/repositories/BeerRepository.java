package org.springframework.sdjpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.sdjpa.domain.Beer;
import org.springframework.sdjpa.domain.BeerStyleEnum;

import java.util.UUID;

/**
 * sdjpa-springdatarest
 *
 * @author Juliane Maran
 * @since 01/03/2026
 */
public interface BeerRepository extends JpaRepository<Beer, UUID> {

  Page<Beer> findAllByBeerName(String beerName, Pageable pageable);

  Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, Pageable pageable);

  Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, Pageable pageable);

  Beer findByUpc(String upc);

}
