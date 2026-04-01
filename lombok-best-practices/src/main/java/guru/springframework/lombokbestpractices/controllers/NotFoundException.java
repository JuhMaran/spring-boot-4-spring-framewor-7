package guru.springframework.lombokbestpractices.controllers;

/**
 * lombok-best-practices
 * @author Juliane Maran
 * @since 01/04/2026
 */
public class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}
