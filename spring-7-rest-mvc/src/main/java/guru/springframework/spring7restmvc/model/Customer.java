package guru.springframework.spring7restmvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Customer {

  private String name;
  private UUID id;
  private Integer version;
  private LocalDateTime createdDate;
  private LocalDateTime updateDate;

}
