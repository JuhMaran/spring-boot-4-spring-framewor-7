package guru.springframework.juniemvc.services;

import guru.springframework.juniemvc.entities.Beer;
import guru.springframework.juniemvc.repositories.BeerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BeerServiceImplTest {

    @Mock
    BeerRepository beerRepository;

    BeerServiceImpl beerService;

    @BeforeEach
    void setUp() {
        beerService = new BeerServiceImpl(beerRepository);
    }

    @Test
    void saveBeerDelegatesToRepository() {
        Beer beer = buildBeer(1);
        when(beerRepository.save(beer)).thenReturn(beer);

        Beer savedBeer = beerService.saveBeer(beer);

        assertThat(savedBeer).isSameAs(beer);
        verify(beerRepository).save(beer);
    }

    @Test
    void findBeerByIdReturnsBeerWhenPresent() {
        Beer beer = buildBeer(1);
        when(beerRepository.findById(1)).thenReturn(Optional.of(beer));

        Optional<Beer> foundBeer = beerService.findBeerById(1);

        assertThat(foundBeer).contains(beer);
        verify(beerRepository).findById(1);
    }

    @Test
    void findBeerByIdReturnsEmptyWhenMissing() {
        when(beerRepository.findById(99)).thenReturn(Optional.empty());

        Optional<Beer> foundBeer = beerService.findBeerById(99);

        assertThat(foundBeer).isEmpty();
        verify(beerRepository).findById(99);
    }

    @Test
    void findAllBeersReturnsBeerList() {
        List<Beer> beers = List.of(buildBeer(1), buildBeer(2));
        when(beerRepository.findAll()).thenReturn(beers);

        List<Beer> foundBeers = beerService.findAllBeers();

        assertThat(foundBeers).containsExactlyElementsOf(beers);
        verify(beerRepository).findAll();
    }

    @Test
    void updateBeerByIdReturnsUpdatedBeerWhenPresent() {
        Beer existingBeer = buildBeer(1);
        Beer updateRequest = buildBeer(null);
        updateRequest.setBeerName("Updated Galaxy Cat");
        updateRequest.setQuantityOnHand(24);
        updateRequest.setPrice(new BigDecimal("21.99"));

        when(beerRepository.findById(1)).thenReturn(Optional.of(existingBeer));
        when(beerRepository.save(any(Beer.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Optional<Beer> updatedBeer = beerService.updateBeerById(1, updateRequest);

        assertThat(updatedBeer).isPresent();
        assertThat(updatedBeer.get().getId()).isEqualTo(1);
        assertThat(updatedBeer.get().getBeerName()).isEqualTo("Updated Galaxy Cat");
        assertThat(updatedBeer.get().getQuantityOnHand()).isEqualTo(24);
        assertThat(updatedBeer.get().getPrice()).isEqualByComparingTo("21.99");
        verify(beerRepository).findById(1);
        verify(beerRepository).save(existingBeer);
    }

    @Test
    void updateBeerByIdReturnsEmptyWhenMissing() {
        when(beerRepository.findById(99)).thenReturn(Optional.empty());

        Optional<Beer> updatedBeer = beerService.updateBeerById(99, buildBeer(null));

        assertThat(updatedBeer).isEmpty();
        verify(beerRepository).findById(99);
        verify(beerRepository, never()).save(any(Beer.class));
    }

    @Test
    void deleteBeerByIdDeletesWhenPresent() {
        when(beerRepository.existsById(1)).thenReturn(true);

        boolean deleted = beerService.deleteBeerById(1);

        assertThat(deleted).isTrue();
        verify(beerRepository).existsById(1);
        verify(beerRepository).deleteById(1);
    }

    @Test
    void deleteBeerByIdReturnsFalseWhenMissing() {
        when(beerRepository.existsById(99)).thenReturn(false);

        boolean deleted = beerService.deleteBeerById(99);

        assertThat(deleted).isFalse();
        verify(beerRepository).existsById(99);
        verify(beerRepository, never()).deleteById(any(Integer.class));
    }

    private Beer buildBeer(Integer id) {
        return Beer.builder()
                .id(id)
                .beerName("Galaxy Cat")
                .beerStyle("IPA")
                .upc("123456789012")
                .quantityOnHand(12)
                .price(new BigDecimal("19.99"))
                .build();
    }
}
