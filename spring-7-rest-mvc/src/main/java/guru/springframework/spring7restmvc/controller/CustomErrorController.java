package guru.springframework.spring7restmvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 22/02/2026
 */
@ControllerAdvice
public class CustomErrorController {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  ResponseEntity handleBindErrors(MethodArgumentNotValidException exception) {
    return ResponseEntity.badRequest().body(exception.getBindingResult().getFieldErrors());
  }

}
