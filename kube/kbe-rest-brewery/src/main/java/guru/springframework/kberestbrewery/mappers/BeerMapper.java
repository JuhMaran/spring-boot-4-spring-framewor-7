package guru.springframework.kberestbrewery.mappers;

import guru.springframework.kberestbrewery.domain.Beer;
import guru.springframework.kberestbrewery.model.BeerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * kbe-rest-brewery
 *
 * @author Juliane Maran
 * @since 03/04/2026
 */
@Mapper(componentModel = "spring")
public interface BeerMapper {

  BeerDto beerToBeerDto(Beer beer);

  BeerDto beerToBeerDtoWithInventory(Beer beer);

  @Mapping(target = "version", ignore = true)
  Beer beerDtoToBeer(BeerDto dto);

}
