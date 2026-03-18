package guru.springframework.spring7aiintro.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenAIServiceImplTest {

  @Autowired
  OpenAIService openAIService;

  @Test
  void getAnswer() {
    String answer = openAIService.getAnswer("Inserir uma pergunta");
    System.out.println("Resposta obtida.");
    System.out.println(answer);
  }

}