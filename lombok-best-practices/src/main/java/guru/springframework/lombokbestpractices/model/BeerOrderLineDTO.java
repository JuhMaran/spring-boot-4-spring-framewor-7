package guru.springframework.lombokbestpractices.model;

import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * lombok-best-practices
 *
 * @author Juliane Maran
 * @since 01/04/2026
 */
@Data
@Builder
public class BeerOrderLineDTO {

  private UUID id;
  private Long version;
  private Timestamp createdDate;
  private Timestamp lastModifiedDate;
  private BeerDTO beerDTO;

  @Min(value = 1, message = "Quantity On Hand must be greater than 0")
  private Integer orderQuantity;
  private Integer quantityAllocated;

}
