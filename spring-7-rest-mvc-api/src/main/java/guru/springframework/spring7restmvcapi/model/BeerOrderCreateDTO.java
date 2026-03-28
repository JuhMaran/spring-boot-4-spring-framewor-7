package guru.springframework.spring7restmvcapi.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 24/03/2026
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerOrderCreateDTO {

  private String customerRef;

  @NotNull
  private UUID customerId;

  private Set<BeerOrderLineCreateDTO> beerOrderLines;

}
