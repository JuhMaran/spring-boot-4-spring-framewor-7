package guru.springframework.spring7reactive.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * spring-7-reactive
 *
 * @author Juliane Maran
 * @since 09/03/2026
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Beer {

  @Id
  private Integer id;
  private String beerName;
  private String beerStyle;
  private String upc;
  private Integer quantityOnHand;
  private BigDecimal price;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

}
