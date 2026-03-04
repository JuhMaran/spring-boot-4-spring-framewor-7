package guru.springframework.resttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO
 *
 * @author Juliane Maran
 * @since 02/03/2026
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeerDTO {

  private UUID id;
  private Integer version;
  private String beerName;
  private BeerStyle beerStyle;
  private String upc;
  private Integer quantityOnHand;
  private BigDecimal price;
  private LocalDateTime createdDate;
  private LocalDateTime updateDate;

}
