package guru.springframework.spring7aiintro.controllers;

import guru.springframework.spring7aiintro.model.Answer;
import guru.springframework.spring7aiintro.model.Question;
import guru.springframework.spring7aiintro.services.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring-7-ai-intro
 *
 * @author Juliane Maran
 * @since 17/03/2026
 */
@RestController
public class QuestionController {

  private final OpenAIService openAIService;

  public QuestionController(OpenAIService openAIService) {
    this.openAIService = openAIService;
  }

  @PostMapping
  public Answer askQuestion(Question question) {
    return openAIService.getAnswer(question);
  }

}
