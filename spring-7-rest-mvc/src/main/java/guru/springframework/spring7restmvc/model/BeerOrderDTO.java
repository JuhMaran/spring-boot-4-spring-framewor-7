package guru.springframework.spring7restmvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

/**
 * DTO - Data Transfer Objects
 *
 * @author Juliane Maran
 * @since 26/02/2026
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerOrderDTO {

  private UUID id;
  private Long version;
  private Timestamp createdDate;
  private Timestamp lastModifiedDate;
  private String customerRef;
  private CustomerDTO customer;
  private Set<BeerOrderLineDTO> beerOrderLines;
  private BeerOrderShipmentDTO beerOrderShipment;

}
