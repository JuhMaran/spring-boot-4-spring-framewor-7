package guru.springframework.spring7reactive.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

/**
 * spring-7-reactive
 *
 * @author Juliane Maran
 * @since 09/03/2026
 */
@Configuration
public class DatabaseConfig {

  @Value("classpath:/schema.sql")
  Resource resource;

  @Bean
  ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
    var initializer = new ConnectionFactoryInitializer();
    initializer.setConnectionFactory(connectionFactory);
    initializer.setDatabasePopulator(new ResourceDatabasePopulator(resource));
    return initializer;
  }

}
