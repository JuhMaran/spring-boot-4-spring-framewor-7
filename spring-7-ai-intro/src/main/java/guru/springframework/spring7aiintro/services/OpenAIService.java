package guru.springframework.spring7aiintro.services;

import guru.springframework.spring7aiintro.model.Answer;
import guru.springframework.spring7aiintro.model.GetCapitalRequest;
import guru.springframework.spring7aiintro.model.GetCapitalResponse;
import guru.springframework.spring7aiintro.model.Question;

/**
 * spring-7-ai-intro
 *
 * @author Juliane Maran
 * @since 17/03/2026
 */
public interface OpenAIService {

  Answer getCapitalWithInfo(GetCapitalRequest getCapitalRequest);

  GetCapitalResponse getCapital(GetCapitalRequest getCapitalRequest);

  String getAnswer(String question);

  Answer getAnswer(Question question);

}
