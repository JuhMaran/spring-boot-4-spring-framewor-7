package guru.springframework.kberestbrewery.controllers;

import guru.springframework.kberestbrewery.model.CustomerDto;
import guru.springframework.kberestbrewery.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * kbe-rest-brewery
 *
 * @author Juliane Maran
 * @since 03/04/2026
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {

    return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity handlePost(@RequestBody @Validated CustomerDto customerDto) {
    CustomerDto savedDto = customerService.saveNewCustomer(customerDto);

    var httpHeaders = new HttpHeaders();
    httpHeaders.add("Location", "/api/v1/customer/" + savedDto.id().toString());

    return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
  }

  @PutMapping("/{customerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void handleUpdate(@PathVariable("customerId") UUID customerId,
                           @Validated @RequestBody CustomerDto customerDto) {
    customerService.updateCustomer(customerId, customerDto);
  }

  @DeleteMapping("/{customerId}")
  public void deleteById(@PathVariable("customerId") UUID customerId) {
    customerService.deleteById(customerId);
  }

}
