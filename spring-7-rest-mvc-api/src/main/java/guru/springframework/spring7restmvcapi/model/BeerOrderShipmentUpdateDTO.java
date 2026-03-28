package guru.springframework.spring7restmvcapi.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
