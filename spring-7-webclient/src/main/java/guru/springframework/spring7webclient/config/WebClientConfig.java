package guru.springframework.spring7webclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * spring-7-webclient
 *
 * @author Juliane Maran
 * @since 14/03/2026
 */
@Configuration
public class WebClientConfig {

  @Bean
  WebClient.Builder webClientBuilder() {
    return WebClient.builder();
  }

}
