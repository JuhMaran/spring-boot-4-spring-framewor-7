package guru.springframework.spring7restmvc.listeners;

import guru.springframework.spring7restmvc.events.BeerCreatedEvent;
import guru.springframework.spring7restmvc.mappers.BeerMapper;
import guru.springframework.spring7restmvc.repositories.BeerAuditRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 22/03/2026
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class BeerCreatedListener {

  private final BeerMapper beerMapper;
  private final BeerAuditRepository beerAuditRepository;

  @Async
  @EventListener
  public void listen(BeerCreatedEvent event) {
    val beerAudit = beerMapper.beerToBeerAudit(event.getBeer());
    beerAudit.setAuditEventType("BEER_CREATED");

    if (event.getAuthentication() != null && event.getAuthentication().getName() != null) {
      beerAudit.setPrincipalName(event.getAuthentication().getName());
    }

    val savedBeerAudit = beerAuditRepository.save(beerAudit);
    log.debug("Beer Audit Saved: {}", savedBeerAudit.getId());

  }

}
