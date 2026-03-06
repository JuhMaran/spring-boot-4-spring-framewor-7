package guru.springframework.spring7restmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

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
    http
      .authorizeHttpRequests(authorize ->
        authorize.anyRequest().authenticated())
      .httpBasic(withDefaults())
      .csrf(httpSecurityCsrfConfigurer ->
        httpSecurityCsrfConfigurer.ignoringRequestMatchers("/api/**"));
    return http.build();
  }

}
