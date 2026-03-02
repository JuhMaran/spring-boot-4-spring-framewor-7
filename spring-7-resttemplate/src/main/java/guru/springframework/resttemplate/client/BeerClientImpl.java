package guru.springframework.resttemplate.client;

import guru.springframework.resttemplate.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * HTTP Client
 *
 * @author Juliane Maran
 * @since 02/03/2026
 */
@Service
@RequiredArgsConstructor
public class BeerClientImpl implements BeerClient {

  private final RestTemplateBuilder restTemplateBuilder;

  private static final String BASE_URL = "http://localhost:8080";
  private static final String GET_BEER_PATH = "/api/v1/beer";

  @Override
  public Page<BeerDTO> listBeers() {
    RestTemplate restTemplate = restTemplateBuilder.build();

    ResponseEntity<String> stringResponse =
      restTemplate.getForEntity(BASE_URL + GET_BEER_PATH, String.class);

    ResponseEntity<Map> mapResponse =
      restTemplate.getForEntity(BASE_URL + GET_BEER_PATH, Map.class);

    System.out.println(stringResponse.getBody());

    return null;
  }

}
