package guru.springframework.spring7reactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.HttpLogFormatter;
import org.zalando.logbook.Sink;
import org.zalando.logbook.json.JsonHttpLogFormatter;
import org.zalando.logbook.logstash.LogstashLogbackSink;

/**
 * Logbook Configuration
 *
 * @author Juliane Maran
 * @since 21/03/2026
 */
@Configuration
public class LogbookConfig {

  @Bean
  public Sink logbookLogStash() {
    HttpLogFormatter formatter = new JsonHttpLogFormatter();
    return new LogstashLogbackSink(formatter);
  }

}
