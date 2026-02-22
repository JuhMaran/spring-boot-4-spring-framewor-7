package guru.springframework.spring7restmvc.mappers;

import guru.springframework.spring7restmvc.entities.Beer;
import guru.springframework.spring7restmvc.model.BeerDTO;
import org.mapstruct.Mapper;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 22/02/2026
 */
@Mapper
public interface BeerMapper {

  Beer beerDtoToBeer(BeerDTO beerDTO);

  BeerDTO beerToBeerDto(Beer beer);

}
