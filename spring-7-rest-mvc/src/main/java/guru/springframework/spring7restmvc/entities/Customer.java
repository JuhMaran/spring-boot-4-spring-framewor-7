package guru.springframework.spring7restmvc.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

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
  @UuidGenerator
  @JdbcTypeCode(SqlTypes.CHAR)
  @GeneratedValue(generator = "UUID")
  @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
  private UUID id;
  private String name;

  @Column(length = 255)
  private String email;

  @Version
  private Integer version;
  private LocalDateTime createdDate;
  private LocalDateTime updateDate;

}
