package guru.springframework.spring7webclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.spring.webflux.LogbookExchangeFilterFunction;

/**
 * spring-7-webclient
 *
 * @author Juliane Maran
 * @since 14/03/2026
 */
@Configuration
public class WebClientConfig {

  private final String rootUrl;
  private final ReactiveOAuth2AuthorizedClientManager authorizedClientManager;

  public WebClientConfig(@Value("${webclient.root-url}") String rootUrl,
                         ReactiveOAuth2AuthorizedClientManager authorizedClientManager) {
    this.rootUrl = rootUrl;
    this.authorizedClientManager = authorizedClientManager;
  }

  @Bean
  WebClient.Builder webClientBuilder() {
    var oauth = new ServerOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager);
    oauth.setDefaultClientRegistrationId("springauth");

    LogbookExchangeFilterFunction logbookWebFilter = new LogbookExchangeFilterFunction(Logbook.builder().build());

    return WebClient.builder()
      .filter(oauth)
      .filter(logbookWebFilter)
      .baseUrl(rootUrl);
  }

}
