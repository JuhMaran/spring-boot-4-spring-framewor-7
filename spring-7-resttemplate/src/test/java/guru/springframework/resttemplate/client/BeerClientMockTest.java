package guru.springframework.resttemplate.client;

import guru.springframework.resttemplate.config.RestTemplateBuilderConfig;
import guru.springframework.resttemplate.model.BeerDTO;
import guru.springframework.resttemplate.model.BeerDTOPageImpl;
import guru.springframework.resttemplate.model.BeerStyle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.boot.restclient.test.MockServerRestTemplateCustomizer;
import org.springframework.boot.restclient.test.autoconfigure.RestClientTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Mock Test Class
 *
 * @author Juliane Maran
 * @since 04/03/2026
 */
@RestClientTest
@Import(RestTemplateBuilderConfig.class)
class BeerClientMockTest {

  static final String URL = "http://localhost:8080";

  BeerClient beerClient;

  MockRestServiceServer server;

  @Autowired
  RestTemplateBuilder restTemplateBuilderConfigured;

  @Autowired
  ObjectMapper objectMapper;

  @Mock
  RestTemplateBuilder mockRestTemplateBuilder = new RestTemplateBuilder(new MockServerRestTemplateCustomizer());

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    RestTemplate restTemplate = restTemplateBuilderConfigured.build();
    server = MockRestServiceServer.bindTo(restTemplate).build();
    when(mockRestTemplateBuilder.build()).thenReturn(restTemplate);
    beerClient = new BeerClientImpl(mockRestTemplateBuilder);
  }

  @Test
  void testListBeers() throws JacksonException {
    String payload = objectMapper.writeValueAsString(getPage());

    server.expect(method(HttpMethod.GET))
      .andExpect(requestTo(URL + BeerClientImpl.GET_BEER_PATH))
      .andRespond(withSuccess(payload, MediaType.APPLICATION_JSON));

    Page<BeerDTO> dtos = beerClient.listBeers();
    assertThat(dtos.getContent().size()).isGreaterThan(0);
  }

  BeerDTO getBeerDto() {
    return BeerDTO.builder()
      .id(UUID.randomUUID())
      .price(new BigDecimal("10.99"))
      .beerName("Mango Bobs")
      .beerStyle(BeerStyle.IPA)
      .quantityOnHand(500)
      .upc("123245")
      .build();
  }

  BeerDTOPageImpl getPage() {
    return new BeerDTOPageImpl(Arrays.asList(getBeerDto()), 1, 25, 1);
  }

}
