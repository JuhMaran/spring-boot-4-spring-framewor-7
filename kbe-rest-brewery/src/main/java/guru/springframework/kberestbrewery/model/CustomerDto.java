package guru.springframework.kberestbrewery.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.UUID;

/**
 * kbe-rest-brewery
 *
 * @author Juliane Maran
 * @since 03/04/2026
 */
@Builder
public record CustomerDto(

  UUID id,

  @NotBlank
  @Size(min = 3, max = 100)
  String name

) {
}
