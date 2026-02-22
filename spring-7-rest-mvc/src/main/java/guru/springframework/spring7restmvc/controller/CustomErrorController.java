package guru.springframework.spring7restmvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Custom Error Body
 *
 * @author Juliane Maran
 * @since 22/02/2026
 */
@RestControllerAdvice
public class CustomErrorController {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  ResponseEntity handleBindErrors(MethodArgumentNotValidException exception) {

    List errorList = exception.getFieldErrors().stream()
      .map(fieldError -> {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        return errorMap;
      }).toList();

    return ResponseEntity.badRequest().body(errorList);
  }

}
