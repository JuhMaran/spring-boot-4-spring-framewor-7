package guru.springframework.spring7reactivemongo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * spring-7-reactive-mongo
 *
 * @author Juliane Maran
 * @since 12/03/2026
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Customer {

  @Id
  private String id;

  private String customerName;

  @CreatedDate
  private LocalDateTime createdDate;

  @LastModifiedDate
  private LocalDateTime lastModifiedDate;

}
