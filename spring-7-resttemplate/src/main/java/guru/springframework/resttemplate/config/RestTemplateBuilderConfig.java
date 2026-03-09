package guru.springframework.resttemplate.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.boot.restclient.autoconfigure.RestTemplateBuilderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.web.util.DefaultUriBuilderFactory;

/**
 * Configuration RestTemplate
 * <p>
 * Alteração: Importação do pacote org.springframework.boot.restclient (SB4) e uso do configurer moderno.
 *
 * @author Juliane Maran
 * @since 03/03/2026
 */
@Configuration
@RequiredArgsConstructor
public class RestTemplateBuilderConfig {

  @Value(value = "${rest.template.rootUrl}")
  String rootUrl;

  @Bean
  OAuth2AuthorizedClientManager auth2AuthorizedClientManager(ClientRegistrationRepository clientRegistrationRepository,
                                                             OAuth2AuthorizedClientService oAuth2AuthorizedClientService) {
    var authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
      .clientCredentials()
      .build();

    var authorizedClientManager = new AuthorizedClientServiceOAuth2AuthorizedClientManager
      (clientRegistrationRepository, oAuth2AuthorizedClientService);
    authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);

    return authorizedClientManager;

  }

  @Bean
  RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer,
                                          OAuthClientInterceptor interceptor) {

    assert rootUrl != null;

    return configurer.configure(new RestTemplateBuilder())
      .additionalInterceptors(interceptor)
      .uriTemplateHandler(new DefaultUriBuilderFactory(rootUrl));

  }

}
