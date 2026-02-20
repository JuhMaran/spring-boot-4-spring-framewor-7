package guru.springframework.spring7restmvc.repositories;

import guru.springframework.spring7restmvc.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 18/02/2026
 */
public interface BeerRepository extends JpaRepository<Beer, UUID> {

}
