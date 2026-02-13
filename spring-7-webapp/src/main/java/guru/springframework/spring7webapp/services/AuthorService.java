package guru.springframework.spring7webapp.services;

import guru.springframework.spring7webapp.domain.Author;

/**
 * spring-7-webapp
 *
 * @author Juliane Maran
 * @since 02/02/2026
 */
public interface AuthorService {

  Iterable<Author> findAll();

}
