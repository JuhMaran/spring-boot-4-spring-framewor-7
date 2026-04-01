package guru.springframework.lombokbestpractices.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

/**
 * lombok-best-practices
 *
 * @author Juliane Maran
 * @since 01/04/2026
 */
@Data
@Builder
public class BeerOrderUpdateDTO {

  private String customerRef;

  @NotNull
  private UUID customerId;

  private Set<BeerOrderLineUpdateDTO> beerOrderLines;

}
