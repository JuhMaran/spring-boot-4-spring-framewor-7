package guru.springframework.spring7reactive.mappers;

import guru.springframework.spring7reactive.domain.Beer;
import guru.springframework.spring7reactive.model.BeerDTO;
import org.mapstruct.Mapper;

/**
 * spring-7-reactive
 *
 * @author Juliane Maran
 * @since 09/03/2026
 */
@Mapper
public interface BeerMapper {

  Beer beerDtoToBeer(BeerDTO beerDTO);

  BeerDTO beerToBeerDto(Beer beer);

}
