package guru.springframework.spring7restmvc.entities;

import guru.springframework.spring7restmvc.model.BeerStyle;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 17/02/2026
 */
@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Beer {

  // @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator") is deprecated since versing 6.5 and marked for removal
  // @GenericGenerator is Deprecated in Spring Boot 3.4.0+
  // Update at end of this lesson!
  @Id
  @GeneratedValue(generator = "UUID")
  @UuidGenerator
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
