package guru.springframework.spring7restmvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 21/02/2026
 */
@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity handleNotFoundException() {
    return ResponseEntity.notFound().build();
  }


}
