package guru.springframework.spring7restmvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Entity
 *
 * @author Juliane Maran
 * @since 21/02/2026
 */
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

  @Id
  private UUID id;

  @Version
  private Integer version;

  private String name;
  private LocalDateTime createdDate;
  private LocalDateTime updateDate;

}
