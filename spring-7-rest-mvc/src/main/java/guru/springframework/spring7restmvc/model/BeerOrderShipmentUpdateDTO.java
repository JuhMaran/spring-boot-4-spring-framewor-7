package guru.springframework.spring7restmvc.model;

import jakarta.validation.constraints.NotBlank;
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
public class BeerOrderShipmentUpdateDTO {

  @NotBlank
  private String trackingNumber;

}
