package guru.springframework.spring7webapp.repositories;

import guru.springframework.spring7webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * spring-7-webapp
 *
 * @author Juliane Maran
 * @since 01/02/2026
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
