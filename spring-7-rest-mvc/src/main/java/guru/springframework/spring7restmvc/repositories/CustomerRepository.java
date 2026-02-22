package guru.springframework.spring7restmvc.repositories;

import guru.springframework.spring7restmvc.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Spring Data JPA Repository
 *
 * @author Juliane Maran
 * @since 21/02/2026
 */
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
