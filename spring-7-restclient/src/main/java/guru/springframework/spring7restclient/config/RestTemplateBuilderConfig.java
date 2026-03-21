package guru.springframework.spring7restclient.config;

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
import org.springframework.web.client.RestClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.spring.LogbookClientHttpRequestInterceptor;

/**
 * RetTemplate Configuration
 *
 * @author Juliane Maran
 * @since 18/03/2026
 */
@Configuration
@RequiredArgsConstructor
public class RestTemplateBuilderConfig {

  @Value("${rest.template.rootUrl}")
  String rootUrl;

  @Bean
  OAuth2AuthorizedClientManager auth2AuthorizedClientManager(ClientRegistrationRepository clientRegistrationRepository,
                                                             OAuth2AuthorizedClientService oAuth2AuthorizedClientService ){
    var authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
      .clientCredentials()
      .build();

    var authorizedClientManager = new AuthorizedClientServiceOAuth2AuthorizedClientManager
      (clientRegistrationRepository, oAuth2AuthorizedClientService);
    authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
    return authorizedClientManager;
  }

  @Bean
  public RestClient.Builder restClientBuilder(RestTemplateBuilder restTemplateBuilder){

    return RestClient.builder(restTemplateBuilder.build());
  }

  @Bean
  RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer,
                                          OAuthClientInterceptor interceptor){

    assert rootUrl != null;

    var logbookInterceptor = new LogbookClientHttpRequestInterceptor(Logbook.builder().build());

    return configurer.configure(new RestTemplateBuilder())
      .additionalInterceptors(interceptor, logbookInterceptor)
      .uriTemplateHandler(new DefaultUriBuilderFactory(rootUrl));
  }

}
