package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.Beer;

import java.util.UUID;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 08/02/2026
 */
public interface BeerService {

  Beer getBeerById(UUID id);

}
