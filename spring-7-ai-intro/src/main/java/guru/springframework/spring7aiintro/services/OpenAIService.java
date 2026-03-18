package guru.springframework.spring7aiintro.services;

import guru.springframework.spring7aiintro.model.Answer;
import guru.springframework.spring7aiintro.model.Question;

/**
 * spring-7-ai-intro
 *
 * @author Juliane Maran
 * @since 17/03/2026
 */
public interface OpenAIService {

  Answer getAnswer(Question question);

  String getAnswer(String question);

}
