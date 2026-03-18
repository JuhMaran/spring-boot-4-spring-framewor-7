package guru.springframework.spring7aiintro.controllers;

import guru.springframework.spring7aiintro.model.Answer;
import guru.springframework.spring7aiintro.model.GetCapitalRequest;
import guru.springframework.spring7aiintro.model.GetCapitalResponse;
import guru.springframework.spring7aiintro.model.Question;
import guru.springframework.spring7aiintro.services.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Question Controller
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

  @PostMapping("/capitalWithInfo")
  public Answer getCapitalWithInfo(@RequestBody GetCapitalRequest getCapitalRequest) {
    return this.openAIService.getCapitalWithInfo(getCapitalRequest);
  }

  @PostMapping("/capital")
  public GetCapitalResponse getCapital(@RequestBody GetCapitalRequest getCapitalRequest) {
    return this.openAIService.getCapital(getCapitalRequest);
  }

  @PostMapping("/ask")
  public Answer askQuestion(@RequestBody Question question) {
    return openAIService.getAnswer(question);
  }

}
