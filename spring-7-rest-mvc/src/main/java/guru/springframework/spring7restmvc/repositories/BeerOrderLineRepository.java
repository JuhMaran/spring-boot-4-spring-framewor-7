package guru.springframework.spring7restmvc.repositories;

import guru.springframework.spring7restmvc.entities.BeerOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 28/03/2026
 */
public interface BeerOrderLineRepository extends JpaRepository<BeerOrderLine, UUID> {

}
