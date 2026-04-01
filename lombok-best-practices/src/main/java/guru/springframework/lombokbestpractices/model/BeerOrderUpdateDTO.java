package guru.springframework.lombokbestpractices.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
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
public class BeerOrderDTO {

  private UUID id;
  private Long version;
  private Timestamp createdDate;
  private Timestamp lastModifiedDate;
  private String customerRef;
  private Set<BeerOrderLineDTO> beerOrderLines;

}
