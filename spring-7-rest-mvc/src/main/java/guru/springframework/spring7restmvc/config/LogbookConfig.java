package guru.springframework.spring7restmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.HttpLogFormatter;
import org.zalando.logbook.Sink;
import org.zalando.logbook.json.JsonHttpLogFormatter;
import org.zalando.logbook.logstash.LogstashLogbackSink;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 21/03/2026
 */
@Configuration
public class LogbookConfig {

  @Bean
  public Sink logstashLogbackSink() {
    HttpLogFormatter formatter = new JsonHttpLogFormatter();
    return new LogstashLogbackSink(formatter);
  }

}
