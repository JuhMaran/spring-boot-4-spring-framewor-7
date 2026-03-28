package guru.springframework.spring7coldservice.services;

import guru.springframework.spring7restmvcapi.events.DrinkRequestEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * spring-7-cold-service
 *
 * @author Juliane Maran
 * @since 28/03/2026
 */
@Slf4j
@Service
public class DrinkRequestProcessorImpl implements DrinkRequestProcessor {
  @Override
  public void processDrinkRequest(DrinkRequestEvent event) {
    log.debug("Processing drink request...");

    //sleep 50 ms
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
