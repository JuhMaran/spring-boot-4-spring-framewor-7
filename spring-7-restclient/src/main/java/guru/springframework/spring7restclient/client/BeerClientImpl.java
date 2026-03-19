package guru.springframework.spring7restclient.client;

import guru.springframework.spring7restclient.model.BeerDTO;
import guru.springframework.spring7restclient.model.BeerStyle;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.UUID;

/**
 * spring-7-restclient
 *
 * @author Juliane Maran
 * @since 18/03/2026
 */
@Service
@RequiredArgsConstructor
public class BeerClientImpl implements BeerClient {

  public static final String GET_BEER_PATH = "/api/v1/beer";
  public static final String GET_BEER_BY_ID_PATH = "/api/v1/beer/{beerId}";

  private final RestClient.Builder restClientBuilder;

  @Override
  public Page<BeerDTO> listBeers() {
    return null;
  }

  @Override
  public Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize) {
    return null;
  }

  @Override
  public BeerDTO getBeerById(UUID beerId) {
    RestClient restClient = restClientBuilder.build();

    return restClient.get()
      .uri(uriBuilder -> uriBuilder
        .path(GET_BEER_BY_ID_PATH)
        .build(beerId))
      .retrieve()
      .body(BeerDTO.class);
  }

  @Override
  public BeerDTO createBeer(BeerDTO newDto) {
    RestClient restClient = restClientBuilder.build();

    val location = restClient.post()
      .uri(uriBuilder -> uriBuilder.path(GET_BEER_PATH).build())
      .body(newDto)
      .retrieve()
      .toBodilessEntity()
      .getHeaders()
      .getLocation();

    return restClient.get()
      .uri(location)
      .retrieve()
      .body(BeerDTO.class);
  }

  @Override
  public BeerDTO updateBeer(BeerDTO beerDto) {
    RestClient restClient = restClientBuilder.build();

    restClient.put()
      .uri(uriBuilder -> uriBuilder
        .path(GET_BEER_BY_ID_PATH)
        .build(beerDto.getId()))
      .body(beerDto)
      .retrieve()
      .toBodilessEntity();

    return getBeerById(beerDto.getId());
  }

  @Override
  public void deleteBeer(UUID beerId) {

  }

}
