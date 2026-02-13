package guru.springframework.spring7webapp.repositories;

import guru.springframework.spring7webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * spring-7-webapp
 *
 * @author Juliane Maran
 * @since 01/02/2026
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
