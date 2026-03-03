package guru.springframework.resttemplate.client;

import guru.springframework.resttemplate.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;

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

    ResponseEntity<JsonNode> jsonResponse =
      restTemplate.getForEntity(BASE_URL + GET_BEER_PATH, JsonNode.class);

    // Antes
//    jsonResponse.getBody().findPath("content")
//      .elements().forEachRemaining(node -> {
//        System.out.println(node.get("beerName").asText());
//      });

    // Jackson 3.x Atualizado
    if (jsonResponse.getBody() != null) {
      // Na Jackson 3, use .path() para segurança e .forEach() direto no nó
      // ou .values() se quiser ser explícito.
      jsonResponse.getBody().path("content")
        .forEach(node -> {
          // .path() é preferível a .get() pois nunca retorna null (evita NPE)
          // .asString() é o novo padrão para Jackson 3.x
          System.out.println(node.path("beerName").asString());
        });
    }

    System.out.println(stringResponse.getBody());

    return null;
  }

}
