package guru.springframework.spring7restmvc.mappers;

import guru.springframework.spring7restmvc.entities.Beer;
import guru.springframework.spring7restmvc.model.BeerDTO;
import org.mapstruct.Mapper;

/**
 * O MapStruct gerará automaticamente classes de mapeamento
 *
 * @author Juliane Maran
 * @since 18/02/2026
 */
@Mapper
public interface BeerMapper {

  Beer beerDtoToBeer(BeerDTO dto);

  BeerDTO beerToBeerDto(Beer beer);

}
