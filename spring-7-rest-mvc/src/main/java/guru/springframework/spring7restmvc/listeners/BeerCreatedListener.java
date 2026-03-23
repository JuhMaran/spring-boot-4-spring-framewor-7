package guru.springframework.spring7restmvc.listeners;

import guru.springframework.spring7restmvc.events.*;
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
  public void listen(BeerEvent event) {
    val beerAudit = beerMapper.beerToBeerAudit(event.getBeer());

    String eventType = null;

    switch (event) {
      case BeerCreatedEvent beerCreatedEvent -> eventType = "BEER_CREATED";
      case BeerPatchedEvent beerPatchedEvent -> eventType = "BEER_PATCHED";
      case BeerUpdatedEvent beerUpdatedEvent -> eventType = "BEER_UPDATED";
      case BeerDeletedEvent beerDeletedEvent -> eventType = "BEER_DELETED";
      default -> eventType = "UNKNOWN";
    }

    beerAudit.setAuditEventType(eventType);

    if (event.getAuthentication() != null && event.getAuthentication().getName() != null) {
      beerAudit.setPrincipalName(event.getAuthentication().getName());
    }

    val savedBeerAudit = beerAuditRepository.save(beerAudit);
    log.debug("Beer Audit Saved: {} - {}", eventType, savedBeerAudit.getId());

  }

}
