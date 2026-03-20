package guru.springframework.spring7restmvc.config;

import org.springframework.boot.security.autoconfigure.actuate.web.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security Config
 *
 * @author Juliane Maran
 * @since 05/03/2026
 */
@Profile("!test")
@Configuration
public class SpringSecConfig {

  @Bean
  @Order(1)
  public SecurityFilterChain actuatorSecurityFilterChain(HttpSecurity http) throws Exception {
    return http
      .securityMatcher(EndpointRequest.toAnyEndpoint())
      .authorizeHttpRequests(authorize ->
        authorize.anyRequest().permitAll())
      .build();
  }

  @Bean
  @Order(2)
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
      .authorizeHttpRequests(authorize -> authorize
        .requestMatchers("/actuator", "/actuator/**").permitAll()
        .requestMatchers("/v3/api-docs**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
        .anyRequest().authenticated())
      .oauth2ResourceServer(httpSecurityOAuth2ResourceServerConfigurer ->
        httpSecurityOAuth2ResourceServerConfigurer.jwt(Customizer.withDefaults()))
      .build();
  }

}
