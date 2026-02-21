package guru.springframework.spring7restmvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tools.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * POJO <br>
 * DTO - Data Transfer Objects
 *
 * @author Juliane Maran
 * @since 21/02/2026
 */
@Data
@Builder
@JsonDeserialize(builder = BeerDTO.BeerDTOBuilder.class)
public class BeerDTO {

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
