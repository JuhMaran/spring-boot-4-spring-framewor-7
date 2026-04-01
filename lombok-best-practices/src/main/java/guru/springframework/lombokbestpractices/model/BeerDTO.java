package guru.springframework.lombokbestpractices.model;

import guru.springframework.lombokbestpractices.entities.BeerStyle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * lombok-best-practices
 *
 * @author Juliane Maran
 * @since 01/04/2026
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerDTO {

  private UUID id;
  private Integer version;

  @NotBlank
  @NotNull
  private String beerName;

  @NotNull
  private BeerStyle beerStyle;

  @NotNull
  @NotBlank
  private String upc;
  private Integer quantityOnHand;

  @NotNull
  private BigDecimal price;
  private LocalDateTime createdDate;
  private LocalDateTime updateDate;

}
