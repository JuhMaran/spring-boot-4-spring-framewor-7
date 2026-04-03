package guru.springframework.juniemvc.services;

import guru.springframework.juniemvc.entities.Beer;
import guru.springframework.juniemvc.repositories.BeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;

    public BeerServiceImpl(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public Beer saveBeer(Beer beer) {
        return beerRepository.save(beer);
    }

    @Override
    public Optional<Beer> findBeerById(Integer beerId) {
        return beerRepository.findById(beerId);
    }

    @Override
    public List<Beer> findAllBeers() {
        return beerRepository.findAll();
    }

    @Override
    public Optional<Beer> updateBeerById(Integer beerId, Beer beer) {
        return beerRepository.findById(beerId)
                .map(existingBeer -> {
                    existingBeer.setBeerName(beer.getBeerName());
                    existingBeer.setBeerStyle(beer.getBeerStyle());
                    existingBeer.setUpc(beer.getUpc());
                    existingBeer.setQuantityOnHand(beer.getQuantityOnHand());
                    existingBeer.setPrice(beer.getPrice());

                    return beerRepository.save(existingBeer);
                });
    }

    @Override
    public boolean deleteBeerById(Integer beerId) {
        if (!beerRepository.existsById(beerId)) {
            return false;
        }

        beerRepository.deleteById(beerId);
        return true;
    }
}
