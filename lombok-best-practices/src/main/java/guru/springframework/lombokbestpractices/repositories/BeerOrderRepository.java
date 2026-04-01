package guru.springframework.lombokbestpractices.repositories;

import guru.springframework.lombokbestpractices.entities.BeerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * lombok-best-practices
 *
 * @author Juliane Maran
 * @since 01/04/2026
 */
public interface BeerOrderRepository extends JpaRepository<BeerOrder, UUID> {
}
