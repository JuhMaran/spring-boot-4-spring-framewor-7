package org.springframework.sdjpa.domain;

import lombok.*;

import java.util.UUID;

/**
 * Entity
 *
 * @author Juliane Maran
 * @since 01/03/2026
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

  private UUID id;
  private String name;

}
