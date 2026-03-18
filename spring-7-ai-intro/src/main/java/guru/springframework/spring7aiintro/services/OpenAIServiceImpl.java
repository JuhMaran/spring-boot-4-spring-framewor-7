package guru.springframework.spring7aiintro.services;

import guru.springframework.spring7aiintro.model.Answer;
import guru.springframework.spring7aiintro.model.Question;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

/**
 * spring-7-ai-intro
 *
 * @author Juliane Maran
 * @since 17/03/2026
 */
@Service
public class OpenAIServiceImpl implements OpenAIService {

  private final ChatClient chatClient;

  public OpenAIServiceImpl(ChatClient.Builder builder) {
    this.chatClient = builder.build();
  }

  @Override
  public Answer getAnswer(Question question) {
    return chatClient.prompt()
      .user(question.question())
      .call()
      .entity(Answer.class);
  }

  @Override
  public String getAnswer(String question) {
    return chatClient.prompt()
      .user(question)
      .call()
      .content();
  }

}
