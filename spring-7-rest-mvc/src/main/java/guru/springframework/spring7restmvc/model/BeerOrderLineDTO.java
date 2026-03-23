package guru.springframework.spring7restmvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * DTO - Data Transfer Objects
 *
 * @author Juliane Maran
 * @since 26/02/2026
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeerOrderLineDTO {

  private UUID id;
  private Long version;
  private Timestamp createdDate;
  private Timestamp lastModifiedDate;
  private BeerDTO beer;
  private Integer orderQuantity;
  private Integer quantityAllocated;

}
