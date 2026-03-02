package guru.springframework.resttemplate.client;

import guru.springframework.resttemplate.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * spring-7-resttemplate
 *
 * @author Juliane Maran
 * @since 02/03/2026
 */
@Service
@RequiredArgsConstructor
public class BeerClientImpl implements BeerClient {

  private final RestTemplateBuilder restTemplateBuilder;

  @Override
  public Page<BeerDTO> listBeers() {
    RestTemplate restTemplate = restTemplateBuilder.build();

    ResponseEntity<String> stringResponse =
      restTemplate.getForEntity("http://localhost:8080/api/v1/beer", String.class);

    System.out.println(stringResponse.getBody());

    return null;
  }

}
