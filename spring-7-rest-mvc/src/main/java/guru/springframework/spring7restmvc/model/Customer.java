package guru.springframework.spring7restmvc.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 21/02/2026
 */
@Data
@Builder
public class Customer {

  private UUID id;
  private Integer version;
  private String name;
  private LocalDateTime createdDate;
  private LocalDateTime updateDate;

}
