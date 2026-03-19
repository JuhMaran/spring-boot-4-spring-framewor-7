package guru.springframework.spring7restclient.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * spring-7-restclient
 *
 * @author Juliane Maran
 * @since 18/03/2026
 */
@Data
@Builder
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
