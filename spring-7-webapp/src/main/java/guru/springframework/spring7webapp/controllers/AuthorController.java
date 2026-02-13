package guru.springframework.spring7webapp.controllers;

import guru.springframework.spring7webapp.services.AuthorService;
import guru.springframework.spring7webapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * spring-7-webapp
 *
 * @author Juliane Maran
 * @since 02/02/2026
 */
@Controller
public class AuthorController {

  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @RequestMapping("/authors")
  public String getAuthors(Model model) {
    model.addAttribute("authors", authorService.findAll());
    return "authors";
  }

}
