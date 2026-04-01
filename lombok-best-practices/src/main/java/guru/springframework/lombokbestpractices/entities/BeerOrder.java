package guru.springframework.lombokbestpractices.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

/**
 * lombok-best-practices
 *
 * @author Juliane Maran
 * @since 01/04/2026
 */
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
public class BeerOrder {

  public BeerOrder(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String customerRef,
                   BigDecimal paymentAmount, Set<BeerOrderLine> beerOrderLines) {
    this.id = id;
    this.version = version;
    this.createdDate = createdDate;
    this.lastModifiedDate = lastModifiedDate;
    this.customerRef = customerRef;
    this.setPaymentAmount(paymentAmount);
    this.setBeerOrderLines(beerOrderLines);
  }

  @Id
  @GeneratedValue(generator = "UUID")
  @UuidGenerator
  @JdbcTypeCode(SqlTypes.CHAR)
  @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
  private UUID id;

  @Version
  private Long version;

  @CreationTimestamp
  @Column(updatable = false)
  private Timestamp createdDate;

  @UpdateTimestamp
  private Timestamp lastModifiedDate;

  public boolean isNew() {
    return this.id == null;
  }

  private String customerRef;

  private BigDecimal paymentAmount;

  @OneToMany(mappedBy = "beerOrder", cascade = CascadeType.ALL)
  private Set<BeerOrderLine> beerOrderLines;

  public void setBeerOrderLines(Set<BeerOrderLine> beerOrderLines) {
    if (beerOrderLines != null) {
      this.beerOrderLines = beerOrderLines;
      beerOrderLines.forEach(beerOrderLine -> beerOrderLine.setBeerOrder(this));
    }
  }

}
