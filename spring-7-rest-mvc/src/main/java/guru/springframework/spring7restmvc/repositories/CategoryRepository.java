package guru.springframework.spring7restmvc.repositories;

import guru.springframework.spring7restmvc.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 27/02/2026
 */
public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
