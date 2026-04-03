package guru.springframework.kberestbrewery.mappers;

import guru.springframework.kberestbrewery.domain.Beer;
import guru.springframework.kberestbrewery.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * kbe-rest-brewery
 *
 * @author Juliane Maran
 * @since 03/04/2026
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

  BeerDto beerToBeerDto(Beer beer);

  BeerDto beerToBeerDtoWithInventory(Beer beer);

  Beer beerDtoToBeer(BeerDto dto);

}
