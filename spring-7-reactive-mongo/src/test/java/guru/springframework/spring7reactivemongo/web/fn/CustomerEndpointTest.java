package guru.springframework.spring7reactivemongo.web.fn;

import guru.springframework.spring7reactivemongo.model.CustomerDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.boot.webtestclient.autoconfigure.AutoConfigureWebTestClient;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;

@Testcontainers
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@AutoConfigureWebTestClient
class CustomerEndpointTest {

  @Container
  @ServiceConnection
  public static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");

  @Autowired
  WebTestClient webTestClient;

  // Status Code: 400 Bad Request

  @Test
  @Order(4)
  void testUpdateCustomerBadRequest() {
    CustomerDTO dto = getSavedTestCustomer();
    dto.setCustomerName("");

    webTestClient.put()
      .uri(CustomerRouterConfig.CUSTOMER_PATH_ID, 1)
      .body(Mono.just(dto), CustomerDTO.class)
      .exchange()
      .expectStatus().isBadRequest();
  }

  // Status Code: 404 Not Found

  @Test
  void testDeleteNotFound() {
    webTestClient.delete()
      .uri(CustomerRouterConfig.CUSTOMER_PATH_ID, 999)
      .exchange()
      .expectStatus().isNotFound();
  }

  @Test
  void testPatchIdNotFound() {
    webTestClient.patch()
      .uri(CustomerRouterConfig.CUSTOMER_PATH_ID, 999)
      .body(Mono.just(getCustomerDto()), CustomerDTO.class)
      .exchange()
      .expectStatus().isNotFound();
  }

  @Test
  void testUpdateCustomerNotFound() {
    webTestClient.put()
      .uri(CustomerRouterConfig.CUSTOMER_PATH_ID, 999)
      .body(Mono.just(getCustomerDto()), CustomerDTO.class)
      .exchange()
      .expectStatus().isNotFound();
  }

  @Test
  void testGetByIdNotFound() {
    webTestClient.get()
      .uri(CustomerRouterConfig.CUSTOMER_PATH_ID, 999)
      .exchange()
      .expectStatus().isNotFound();
  }

  // Status Code: 204 No Content

  @Test
  @Order(999)
  void testDeleteCustomer() {
    CustomerDTO dto = getSavedTestCustomer();

    webTestClient.delete()
      .uri(CustomerRouterConfig.CUSTOMER_PATH_ID, dto.getId())
      .exchange()
      .expectStatus().isNoContent();
  }

  @Test
  @Order(3)
  void testUpdateCustomer() {
    CustomerDTO dto = getSavedTestCustomer();

    webTestClient.put()
      .uri(CustomerRouterConfig.CUSTOMER_PATH_ID, dto.getId())
      .body(Mono.just(dto), CustomerDTO.class)
      .exchange()
      .expectStatus().isNoContent();
  }

  // Status Code: 201 Created

  @Test
  void testCreateCustomer() {
    webTestClient.post().uri(CustomerRouterConfig.CUSTOMER_PATH)
      .body(Mono.just(getCustomerDto()), CustomerDTO.class)
      .header("Content-type", "application/json")
      .exchange()
      .expectStatus().isCreated()
      .expectHeader().exists("Location");
  }

  // Status Code: 200 OK

  @Test
  @Order(1)
  void testGetById() {
    CustomerDTO dto = getSavedTestCustomer();

    webTestClient.get().uri(CustomerRouterConfig.CUSTOMER_PATH_ID, dto.getId())
      .exchange()
      .expectStatus().isOk()
      .expectHeader().valueEquals("Content-type", "application/json")
      .expectBody(CustomerDTO.class);
  }

  @Test
  @Order(2)
  void testListCustomers() {
    webTestClient.get().uri(CustomerRouterConfig.CUSTOMER_PATH)
      .exchange()
      .expectStatus().isOk()
      .expectHeader().valueEquals("Content-type", "application/json")
      .expectBody().jsonPath("$.size()").value(greaterThan(1));
  }

  // Auxiliary Methods

  public CustomerDTO getSavedTestCustomer() {
    FluxExchangeResult<CustomerDTO> beerDTOFluxExchangeResult = webTestClient.post()
      .uri(CustomerRouterConfig.CUSTOMER_PATH)
      .body(Mono.just(getCustomerDto()), CustomerDTO.class)
      .header("Content-Type", "application/json")
      .exchange()
      .returnResult(CustomerDTO.class);

    List<String> location = beerDTOFluxExchangeResult.getResponseHeaders().get("Location");

    return webTestClient.get().uri(location.get(0))
      .exchange().returnResult(CustomerDTO.class).getResponseBody().blockFirst();
  }

  public static CustomerDTO getCustomerDto() {
    return CustomerDTO.builder()
      .customerName("Test Customer")
      .build();
  }

}