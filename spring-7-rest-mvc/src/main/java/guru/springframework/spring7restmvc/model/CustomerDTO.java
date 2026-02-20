package guru.springframework.spring7restmvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tools.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Data Transfer Objects - DTO
 *
 * @author Juliane Maran
 * @since 10/02/2026
 */
@Data
@Builder
@JsonDeserialize(builder = CustomerDTO.CustomerDTOBuilder.class)
public class CustomerDTO {

  @JsonProperty("id")
  private UUID id;

  @JsonProperty("version")
  private Integer version;

  @JsonProperty("name")
  private String name;

  private LocalDateTime createdDate;
  private LocalDateTime updateDate;

}
