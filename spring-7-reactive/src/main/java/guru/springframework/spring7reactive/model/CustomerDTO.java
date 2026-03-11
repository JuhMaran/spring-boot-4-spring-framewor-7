package guru.springframework.spring7reactive.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * spring-7-reactive
 *
 * @author Juliane Maran
 * @since 10/03/2026
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

  private Integer id;

  @Size(max = 255)
  private String customerName;

  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

}
