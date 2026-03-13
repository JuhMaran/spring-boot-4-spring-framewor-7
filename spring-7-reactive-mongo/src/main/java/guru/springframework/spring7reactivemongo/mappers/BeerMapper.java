package guru.springframework.spring7reactivemongo.mappers;

import guru.springframework.spring7reactivemongo.domain.Beer;
import guru.springframework.spring7reactivemongo.model.BeerDTO;
import org.mapstruct.Mapper;

/**
 * spring-7-reactive-mongo
 *
 * @author Juliane Maran
 * @since 12/03/2026
 */
@Mapper
public interface BeerMapper {

  BeerDTO beerToBeerDto(Beer beer);

  Beer beerDtoToBeer(BeerDTO beerDTO);

}
