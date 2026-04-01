package guru.springframework.lombokbestpractices.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class BeerOrderLineUpdateDTO {

  private UUID id;

  @NotNull
  private UUID beerId;

  @Min(value = 1, message = "Quantity On Hand must be greater than 0")
  private Integer orderQuantity;

  private Integer quantityAllocated;

}
