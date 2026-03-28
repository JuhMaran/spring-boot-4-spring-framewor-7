package guru.springframework.spring7restmvcapi.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class BeerOrderLineUpdateDTO {

  private UUID id;

  @NotNull
  private UUID beerId;

  @Min(value = 1, message = "Quantity On Hand must be greater than 0")
  private Integer orderQuantity;

  private Integer quantityAllocated;

}
