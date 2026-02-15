package guru.springframework.spring7restmvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tools.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 10/02/2026
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(builder = Customer.CustomerBuilder.class)
public class Customer {

  @JsonProperty("name")
  private String name;

  @JsonProperty("id")
  private UUID id;

  @JsonProperty("version")
  private Integer version;

  private LocalDateTime createdDate;
  private LocalDateTime updateDate;

}
