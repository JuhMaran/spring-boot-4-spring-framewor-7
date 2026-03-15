package guru.springframework.spring7reactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * Security Configuration
 *
 * @author Juliane Maran
 * @since 15/03/2026
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

  @Bean
  SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    http
      .authorizeExchange(authorizeExchangeSpec ->
        authorizeExchangeSpec.anyExchange().authenticated())
      .oauth2ResourceServer(oAuth2ResourceServerSpec ->
        oAuth2ResourceServerSpec.jwt(Customizer.withDefaults()));

    return http.build();
  }

}
