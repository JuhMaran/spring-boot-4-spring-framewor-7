package guru.springframework.kberestbrewery.domain;

import guru.springframework.kberestbrewery.model.BeerStyleEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * kbe-rest-brewery
 *
 * @author Juliane Maran
 * @since 03/04/2026
 */
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Beer {

  @Id
  @GeneratedValue(generator = "UUID")
  @UuidGenerator
  @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
  @JdbcTypeCode(SqlTypes.CHAR)
  private UUID id;

  @Version
  private Long version;

  private String beerName;
  private BeerStyleEnum beerStyle;
  private String upc;

  private Integer quantityOnHand;
  private BigDecimal price;

  @CreationTimestamp
  @Column(updatable = false)
  private LocalDateTime createdDate;

  @UpdateTimestamp
  private LocalDateTime updateDate;

}
