package guru.springframework.spring7restmvc.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception Handler
 *
 * @author Juliane Maran
 * @since 16/02/2026
 */
@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity handleNotFoundException() {
    System.out.println("In exception handler");
    return ResponseEntity.notFound().build();
  }

}
