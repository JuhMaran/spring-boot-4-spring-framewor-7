package guru.springframework.spring7aiintro.services;

import guru.springframework.spring7aiintro.model.Answer;
import guru.springframework.spring7aiintro.model.GetCapitalRequest;
import guru.springframework.spring7aiintro.model.GetCapitalResponse;
import guru.springframework.spring7aiintro.model.Question;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

/**
 * spring-7-ai-intro
 *
 * @author Juliane Maran
 * @since 17/03/2026
 */
@Service
public class OpenAIServiceImpl implements OpenAIService {

  private final ChatModel chatModel;

  @Value("classpath:templates/get-capital-prompt.st")
  private Resource getCapitalPrompt;

  @Value("classpath:templates/get-capital-with-info.st")
  private Resource getCapitalPromptWithInfo;

  public OpenAIServiceImpl(ChatModel chatModel) {
    this.chatModel = chatModel;
  }

  @Override
  public Answer getCapitalWithInfo(GetCapitalRequest getCapitalRequest) {
    PromptTemplate promptTemplate = new PromptTemplate(getCapitalPromptWithInfo);
    Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", getCapitalRequest.stateOrCountry()));
    ChatResponse response = chatModel.call(prompt);

    return new Answer(Objects.requireNonNull(response.getResult()).getOutput().getText());
  }

  @Override
  public GetCapitalResponse getCapital(GetCapitalRequest getCapitalRequest) {

    BeanOutputConverter<GetCapitalResponse> converter = new BeanOutputConverter<>(GetCapitalResponse.class);
    String format = converter.getFormat();
    System.out.println("Format: \n" + format);

    PromptTemplate promptTemplate = new PromptTemplate(getCapitalPrompt);
    Prompt prompt = promptTemplate.create(Map.of(
      "stateOrCountry", getCapitalRequest.stateOrCountry(),
      "format", format));
    ChatResponse response = chatModel.call(prompt);

    return converter.convert(Objects.requireNonNull(Objects.requireNonNull(response.getResult()).getOutput().getText()));

  }

  @Override
  public Answer getAnswer(Question question) {
    System.out.println("I was called");

    PromptTemplate promptTemplate = new PromptTemplate(question.question());
    Prompt prompt = promptTemplate.create();
    ChatResponse response = chatModel.call(prompt);

    return new Answer(Objects.requireNonNull(response.getResult()).getOutput().getText());
  }

  @Override
  public String getAnswer(String question) {
    PromptTemplate promptTemplate = new PromptTemplate(question);
    Prompt prompt = promptTemplate.create();
    ChatResponse response = chatModel.call(prompt);

    return Objects.requireNonNull(response.getResult()).getOutput().getText();
  }

}