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
 * @since 27/02/2026
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeerOrderShipmentDTO {

  private UUID id;
  private Long version;
  private String trackingNumber;
  private Timestamp createdDate;
  private Timestamp lastModifiedDate;

}
