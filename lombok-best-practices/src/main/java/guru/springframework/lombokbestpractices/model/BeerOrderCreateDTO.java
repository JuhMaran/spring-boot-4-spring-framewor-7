package guru.springframework.lombokbestpractices.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
public class BeerOrderCreateDTO {

  private String customerRef;

  @NotNull
  private UUID customerId;

  private Set<BeerOrderLineCreateDTO> beerOrderLines;

}
