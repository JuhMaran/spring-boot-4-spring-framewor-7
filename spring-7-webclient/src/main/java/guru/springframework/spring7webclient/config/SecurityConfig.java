package guru.springframework.spring7webclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;

/**
 * Spring Security Client Configuration
 *
 * @author Juliane Maran
 * @since 15/03/2026
 */
@Configuration
public class SecurityConfig {

  @Bean
  public ReactiveOAuth2AuthorizedClientManager authorizedClientManager(
    ReactiveClientRegistrationRepository clientRegistrationRepository,
    ReactiveOAuth2AuthorizedClientService authorizedClientService) {

    ReactiveOAuth2AuthorizedClientProvider authorizedClientProvider = ReactiveOAuth2AuthorizedClientProviderBuilder
      .builder()
      .clientCredentials()
      .build();

    var authorizedClientManager = new AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager(
      clientRegistrationRepository, authorizedClientService);

    authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);

    return authorizedClientManager;
  }

}
