package guru.springframework.kberestbrewery.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * kbe-rest-brewery
 *
 * @author Juliane Maran
 * @since 03/04/2026
 */
@Builder(toBuilder = true)
public record BeerDto(

  @Null
  UUID id,

  @NotBlank
  String beerName,

  @NotBlank
  String beerStyle,

  String upc,
  BigDecimal price,
  Integer quantityOnHand,
  LocalDateTime createdDate,
  LocalDateTime lastUpdatedDate

) {
}
