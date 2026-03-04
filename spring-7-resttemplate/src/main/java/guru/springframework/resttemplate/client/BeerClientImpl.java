package guru.springframework.resttemplate.client;

import guru.springframework.resttemplate.model.BeerDTO;
import guru.springframework.resttemplate.model.BeerDTOPageImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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

  private static final String GET_BEER_PATH = "/api/v1/beer";

  @Override
  public Page<BeerDTO> listBeers() {
    RestTemplate restTemplate = restTemplateBuilder.build();

    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(GET_BEER_PATH);

    ResponseEntity<BeerDTOPageImpl> response =
      restTemplate.getForEntity(uriComponentsBuilder.toUriString(), BeerDTOPageImpl.class);

    return response.getBody();
  }

}
