package guru.springframework.resttemplate.config;

import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.boot.restclient.autoconfigure.RestTemplateBuilderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.DefaultUriBuilderFactory;

/**
 * spring-7-resttemplate
 *
 * @author Juliane Maran
 * @since 03/03/2026
 */
@Configuration
public class RestTemplateBuilderConfig {

  @Bean
  RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer) {
    RestTemplateBuilder builder = configurer.configure(new RestTemplateBuilder());
    var uriBuilderFactory = new DefaultUriBuilderFactory("http://localhost:8080");
    return builder.uriTemplateHandler(uriBuilderFactory);
  }

}
