package guru.springframework.spring7aiintro.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * spring-7-ai-intro
 *
 * @author Juliane Maran
 * @since 18/03/2026
 */
public record GetCapitalResponse(@JsonPropertyDescription("This is the city name") String answer) {
}
