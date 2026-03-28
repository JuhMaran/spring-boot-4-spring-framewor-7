package guru.springframework.spring7restmvcapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO - Data Transfer Objects
 *
 * @author Juliane Maran
 * @since 21/02/2026
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

  private UUID id;
  private String name;
  private Integer version;
  private LocalDateTime createdDate;
  private LocalDateTime updateDate;

}
