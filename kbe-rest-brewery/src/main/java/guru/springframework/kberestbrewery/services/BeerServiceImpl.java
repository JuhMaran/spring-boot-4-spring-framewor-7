package guru.springframework.kberestbrewery.services;

import guru.springframework.kberestbrewery.controllers.NotFoundException;
import guru.springframework.kberestbrewery.domain.Beer;
import guru.springframework.kberestbrewery.mappers.BeerMapper;
import guru.springframework.kberestbrewery.model.BeerDto;
import guru.springframework.kberestbrewery.model.BeerPagedList;
import guru.springframework.kberestbrewery.model.BeerStyleEnum;
import guru.springframework.kberestbrewery.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.stream.Collectors;

/**
 * kbe-rest-brewery
 *
 * @author Juliane Maran
 * @since 03/04/2026
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

  private final BeerMapper beerMapper;
  private final BeerRepository beerRepository;

  @Override
  @Cacheable(cacheNames = "beerListCache", condition = "#showInventoryOnHand == false ")
  public BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand) {
    BeerPagedList beerPagedList;
    Page<Beer> beerPage;

    if (!StringUtils.isEmpty(beerName) && !StringUtils.isEmpty(beerStyle)) {
      //search both
      beerPage = beerRepository.findAllByBeerNameAndBeerStyle(beerName, beerStyle, pageRequest);
    } else if (!StringUtils.isEmpty(beerName) && StringUtils.isEmpty(beerStyle)) {
      //search beer_service name
      beerPage = beerRepository.findAllByBeerName(beerName, pageRequest);
    } else if (StringUtils.isEmpty(beerName) && !StringUtils.isEmpty(beerStyle)) {
      //search beer_service style
      beerPage = beerRepository.findAllByBeerStyle(beerStyle, pageRequest);
    } else {
      beerPage = beerRepository.findAll(pageRequest);
    }

    if (Boolean.TRUE.equals(showInventoryOnHand)) {
      beerPagedList = new BeerPagedList(beerPage
        .getContent()
        .stream()
        .map(beerMapper::beerToBeerDtoWithInventory)
        .collect(Collectors.toList()),
        PageRequest
          .of(beerPage.getPageable().getPageNumber(),
            beerPage.getPageable().getPageSize()),
        beerPage.getTotalElements());
    } else {
      beerPagedList = new BeerPagedList(beerPage
        .getContent()
        .stream()
        .map(beerMapper::beerToBeerDto)
        .collect(Collectors.toList()),
        PageRequest
          .of(beerPage.getPageable().getPageNumber(),
            beerPage.getPageable().getPageSize()),
        beerPage.getTotalElements());
    }

    return beerPagedList;
  }

  @Override
  @Cacheable(cacheNames = "beerCache", key = "#beerId", condition = "#showInventoryOnHand == false ")
  public BeerDto getById(UUID beerId, Boolean showInventoryOnHand) {
    if (Boolean.TRUE.equals(showInventoryOnHand)) {
      return beerMapper.beerToBeerDtoWithInventory(
        beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
      );
    } else {
      return beerMapper.beerToBeerDto(
        beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
      );
    }
  }

  @Override
  public BeerDto saveNewBeer(BeerDto beerDto) {
    return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
  }

  @Override
  public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
    Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

    beer.setBeerName(beerDto.beerName());
    beer.setBeerStyle(BeerStyleEnum.valueOf(beerDto.beerStyle()));
    beer.setPrice(beerDto.price());
    beer.setUpc(beerDto.upc());

    return beerMapper.beerToBeerDto(beerRepository.save(beer));
  }

  @Override
  @Cacheable(cacheNames = "beerUpcCache")
  public BeerDto getByUpc(String upc) {
    return beerMapper.beerToBeerDto(beerRepository.findByUpc(upc));
  }

  @Override
  public void deleteBeerById(UUID beerId) {
    beerRepository.deleteById(beerId);
  }

}
