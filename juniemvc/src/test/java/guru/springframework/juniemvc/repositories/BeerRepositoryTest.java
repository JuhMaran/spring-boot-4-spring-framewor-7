package guru.springframework.juniemvc.repositories;

import guru.springframework.juniemvc.entities.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void givenBeerData_whenSaveBeer_thenBeerIsPersisted() {
        // Given
        Beer beerToSave = buildBeer();

        // When
        Beer savedBeer = beerRepository.save(beerToSave);

        // Then
        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }

    @Test
    void givenPersistedBeer_whenFindById_thenBeerIsReturned() {
        // Given
        Beer savedBeer = beerRepository.save(buildBeer());

        // When
        Optional<Beer> foundBeer = beerRepository.findById(savedBeer.getId());

        // Then
        assertThat(foundBeer).isPresent();
        assertThat(foundBeer.get().getId()).isEqualTo(savedBeer.getId());
    }

    @Test
    void givenPersistedBeers_whenFindAll_thenBeerListIsReturned() {
        // Given
        beerRepository.save(buildBeer());
        beerRepository.save(buildBeer());

        // When
        List<Beer> beers = beerRepository.findAll();

        // Then
        assertThat(beers).hasSize(2);
    }

    @Test
    void givenPersistedBeer_whenUpdateBeer_thenUpdatedBeerIsPersisted() {
        // Given
        Beer savedBeer = beerRepository.save(buildBeer());
        String updatedName = "Updated Beer Name";

        // When
        savedBeer.setBeerName(updatedName);
        Beer updatedBeer = beerRepository.save(savedBeer);

        // Then
        assertThat(updatedBeer.getBeerName()).isEqualTo(updatedName);
        assertThat(beerRepository.findById(savedBeer.getId()))
                .isPresent()
                .get()
                .extracting(Beer::getBeerName)
                .isEqualTo(updatedName);
    }

    @Test
    void givenPersistedBeer_whenDeleteBeer_thenBeerIsRemoved() {
        // Given
        Beer savedBeer = beerRepository.save(buildBeer());

        // When
        beerRepository.deleteById(savedBeer.getId());

        // Then
        assertThat(beerRepository.findById(savedBeer.getId())).isEmpty();
    }

    private Beer buildBeer() {
        return Beer.builder()
                .beerName("Galaxy Cat")
                .beerStyle("IPA")
                .upc("123456789012")
                .quantityOnHand(12)
                .price(new BigDecimal("19.99"))
                .build();
    }

}
