package guru.springframework.spring7restmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.csrf(httpSecurityCsrfConfigurer -> {
      // Disable CSRF
      httpSecurityCsrfConfigurer.ignoringRequestMatchers("/api/**");
    });

    return http.build();
  }

}
