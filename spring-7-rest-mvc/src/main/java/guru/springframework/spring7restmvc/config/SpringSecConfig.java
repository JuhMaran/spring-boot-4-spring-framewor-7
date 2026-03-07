package guru.springframework.spring7restmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security Config
 *
 * @author Juliane Maran
 * @since 05/03/2026
 */
@Configuration
public class SpringSecConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) {
    http.authorizeHttpRequests(authorize -> {
        authorize.anyRequest().authenticated();
      })
      .oauth2ResourceServer(httpSecurityOAuth2ResourceServerConfigurer -> {
        httpSecurityOAuth2ResourceServerConfigurer.jwt(Customizer.withDefaults());
      });

    return http.build();
  }

}
