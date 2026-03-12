package guru.springframework.spring7reactivemongo.repositories;

import guru.springframework.spring7reactivemongo.domain.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * spring-7-reactive-mongo
 *
 * @author Juliane Maran
 * @since 12/03/2026
 */
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
}
