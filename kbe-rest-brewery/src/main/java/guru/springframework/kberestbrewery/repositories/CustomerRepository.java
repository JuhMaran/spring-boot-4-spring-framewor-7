package guru.springframework.kberestbrewery.repositories;

import guru.springframework.kberestbrewery.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * kbe-rest-brewery
 *
 * @author Juliane Maran
 * @since 03/04/2026
 */
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
