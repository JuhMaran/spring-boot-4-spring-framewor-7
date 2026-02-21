package guru.springframework.spring7restmvc.entities;

import guru.springframework.spring7restmvc.model.BeerStyle;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
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
public class Beer {

  @Id
  @UuidGenerator
  @GeneratedValue(generator = "UUID")
  @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
  private UUID id;

  @Version
  private Integer version;
  private String beerName;
  private BeerStyle beerStyle;
  private String upc;
  private Integer quantityOnHand;
  private BigDecimal price;
  private LocalDateTime createdDate;
  private LocalDateTime updateDate;

}
