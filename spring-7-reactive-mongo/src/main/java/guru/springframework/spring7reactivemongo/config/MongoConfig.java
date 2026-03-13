package guru.springframework.spring7reactivemongo.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

import java.util.Collections;

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
    MongoClientSettings settings = MongoClientSettings.builder()
      .credential(
        MongoCredential.createCredential(
          "root",
          "spring-reactive-mongo",
          "root".toCharArray()))
      .applyToClusterSettings(builder ->
        builder.hosts(Collections.singletonList(
          new ServerAddress("127.0.0.1", 27017)
        )))
      .build();

    return MongoClients.create(settings);
  }

  @Override
  protected String getDatabaseName() {
    return "sfg";
  }

}
