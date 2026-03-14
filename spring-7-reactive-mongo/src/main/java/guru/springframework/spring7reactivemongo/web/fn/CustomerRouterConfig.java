package guru.springframework.spring7reactivemongo.web.fn;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * WebFlux Router
 *
 * @author Juliane Maran
 * @since 14/03/2026
 */
@Configuration
@RequiredArgsConstructor
public class CustomerRouterConfig {

  public static final String CUSTOMER_PATH = "/api/v3/customer";
  public static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{customerId}";

  private final CustomerHandler handler;

  @Bean
  public RouterFunction<ServerResponse> customerRoutes() {
    return route()
      .GET(CUSTOMER_PATH, accept(APPLICATION_JSON), handler::listCustomers)
      .GET(CUSTOMER_PATH_ID, accept(APPLICATION_JSON), handler::getCustomerById)
      .POST(CUSTOMER_PATH, accept(APPLICATION_JSON), handler::createNewCustomer)
      .PUT(CUSTOMER_PATH_ID, accept(APPLICATION_JSON), handler::updateCustomerById)
      .PATCH(CUSTOMER_PATH_ID, accept(APPLICATION_JSON), handler::patchCustomerById)
      .DELETE(CUSTOMER_PATH_ID, accept(APPLICATION_JSON), handler::deleteCustomerById)
      .build();
  }

}
