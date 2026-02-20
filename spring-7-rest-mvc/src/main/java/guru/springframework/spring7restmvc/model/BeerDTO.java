package guru.springframework.spring7restmvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tools.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Data Transfer Objects - DTO
 *
 * @author Juliane Maran
 * @since 07/02/2026
 */
@Data // Acesso via getters/setters
@Builder // Construção controlada
@JsonDeserialize(builder = BeerDTO.BeerDTOBuilder.class)
public class BeerDTO {

  // Atributos privados
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("version")
  private Integer version;

  @JsonProperty("beerName")
  private String beerName;

  @JsonProperty("beerStyle")
  private BeerStyle beerStyle;

  @JsonProperty("upc")
  private String upc;

  @JsonProperty("quantityOnHand")
  private Integer quantityOnHand;

  @JsonProperty("price")
  private BigDecimal price;

  private LocalDateTime createdDate;
  private LocalDateTime updateDate;

}
