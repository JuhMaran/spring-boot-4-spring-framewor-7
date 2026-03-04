package guru.springframework.resttemplate.client;

import guru.springframework.resttemplate.model.BeerDTO;
import guru.springframework.resttemplate.model.BeerDTOPageImpl;
import guru.springframework.resttemplate.model.BeerStyle;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

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
  private static final String GET_BEER_BY_ID_PATH = "/api/v1/beer/{beerId}";

  @Override
  public BeerDTO createBeer(BeerDTO newDto) {
    RestTemplate restTemplate = restTemplateBuilder.build();

    // ResponseEntity<BeerDTO> response = restTemplate.postForEntity(GET_BEER_PATH, newDto, BeerDTO.class);
    URI uri = restTemplate.postForLocation(GET_BEER_PATH, newDto);
    return restTemplate.getForObject(uri.getPath(), BeerDTO.class);

  }

  @Override
  public BeerDTO getBeerById(UUID beerId) {
    RestTemplate restTemplate = restTemplateBuilder.build();
    return restTemplate.getForObject(GET_BEER_BY_ID_PATH, BeerDTO.class, beerId);
  }

  @Override
  public Page<BeerDTO> listBeers() {
    return this.listBeers(null, null, null, null, null);
  }

  @Override
  public Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize) {
    RestTemplate restTemplate = restTemplateBuilder.build();

    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(GET_BEER_PATH);

    if (beerName != null) {
      uriComponentsBuilder.queryParam("beerName", beerName);
    }

    if (beerStyle != null) {
      uriComponentsBuilder.queryParam("beerStyle", beerStyle);
    }

    if (showInventory != null) {
      uriComponentsBuilder.queryParam("showInventory", beerStyle);
    }

    if (pageNumber != null) {
      uriComponentsBuilder.queryParam("pageNumber", beerStyle);
    }

    if (pageSize != null) {
      uriComponentsBuilder.queryParam("pageSize", beerStyle);
    }

    ResponseEntity<BeerDTOPageImpl> response =
      restTemplate.getForEntity(uriComponentsBuilder.toUriString(), BeerDTOPageImpl.class);

    return response.getBody();
  }

}
