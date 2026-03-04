package guru.springframework.resttemplate.client;

import guru.springframework.resttemplate.model.BeerDTO;
import guru.springframework.resttemplate.model.BeerDTOPageImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    ResponseEntity<BeerDTOPageImpl> stringResponse =
      restTemplate.getForEntity(BASE_URL + GET_BEER_PATH, BeerDTOPageImpl.class);

    return null;
  }

}
