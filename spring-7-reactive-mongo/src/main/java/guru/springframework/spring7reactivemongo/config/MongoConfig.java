package guru.springframework.spring7reactivemongo.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

/**
 * spring-7-reactive-mongo
 *
 * @author Juliane Maran
 * @since 12/03/2026
 */
@Configuration
public class MongoConfig extends AbstractReactiveMongoConfiguration {

  @Bean
  public MongoClient mongoClient() {
    return MongoClients.create();
  }

  @Override
  protected String getDatabaseName() {
    return "sfg";
  }

}
