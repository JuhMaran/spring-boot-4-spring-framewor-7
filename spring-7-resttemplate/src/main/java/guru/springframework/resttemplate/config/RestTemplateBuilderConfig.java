package guru.springframework.resttemplate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.boot.restclient.autoconfigure.RestTemplateBuilderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class RestTemplateBuilderConfig {

  @Value("${rest.template.rootUrl}")
  String rootUrl;

  @Bean
  RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer) {

    assert rootUrl != null;

    RestTemplateBuilder builder = configurer.configure(new RestTemplateBuilder());

    DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(rootUrl);

    return builder.uriTemplateHandler(uriBuilderFactory);

  }

}
