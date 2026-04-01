package guru.springframework.lombokbestpractices.mappers;

import guru.springframework.lombokbestpractices.entities.BeerOrder;
import guru.springframework.lombokbestpractices.entities.BeerOrderLine;
import guru.springframework.lombokbestpractices.model.BeerOrderDTO;
import guru.springframework.lombokbestpractices.model.BeerOrderLineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * lombok-best-practices
 *
 * @author Juliane Maran
 * @since 01/04/2026
 */
@Mapper(uses = {BeerMapper.class})
public interface BeerOrderMapper {

  @Mapping(target = "beer", source = "beerDTO")
  @Mapping(target = "beerOrder", ignore = true)
  BeerOrderLine beerOrderLineDtoToBeerOrderLine(BeerOrderLineDTO beerOrderLineDTO);

  @Mapping(target = "beerDTO", source = "beer")
  BeerOrderLineDTO beerOrderLineToBeerOrderLineDto(BeerOrderLine beerOrderLine);

  @Mapping(target = "paymentAmount", ignore = true)
  BeerOrder beerOrderDtoToBeerOrder(BeerOrderDTO beerOrder);

  BeerOrderDTO beerOrderToBeerOrderDto(BeerOrder beerOrder);

}
