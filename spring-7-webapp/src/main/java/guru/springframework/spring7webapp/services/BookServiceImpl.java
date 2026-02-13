package guru.springframework.spring7webapp.services;

import guru.springframework.spring7webapp.domain.Book;
import guru.springframework.spring7webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

/**
 * spring-7-webapp
 *
 * @author Juliane Maran
 * @since 02/02/2026
 */
@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Iterable<Book> findAll() {
    return bookRepository.findAll();
  }

}
