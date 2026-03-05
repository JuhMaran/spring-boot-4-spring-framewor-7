Esta documentação técnica tem como objetivo orientar a equipe de desenvolvimento na migração e padronização de testes de
integração para clientes REST, utilizando o ecossistema **Spring Boot 4, Spring Framework 7, Java 25 (LTS) e Jackson 3.x
**.

# Guia de Migração e Padrões de Teste: Spring Boot 4 & Java 25

## 1 Visão Geral das Mudanças de Ecossistema

Com o lançamento das versões 2025/2026, ocorreram mudanças estruturais significativas que afetam como escrevemos
clientes HTTP e seus respectivos testes.

### 1.1 Jackson 3.x (Namespace `tools.jackson`)

A principal mudança é a alteração do pacote base de `com.fasterxml.jackson` para `tools.jackson`. Além disso, a
biblioteca tornou-se mais rigorosa com tipos e coerção.

| Recurso                   | Antigo (2.x)              | Novo (3.x)         |
|:--------------------------|:--------------------------|:-------------------|
| **Exception Base**        | `JsonProcessingException` | `JacksonException` |
| **Namespace**             | `com.fasterxml.jackson.*` | `tools.jackson.*`  |
| **Verificação de String** | `.isTextual()`            | `.isString()`      |
| **Conversão de Valor**    | `.asText()`               | `.asString()`      |

### 1.2 Java 25 (Encapsulamento Forte)

O Java 25 aprofundou o encapsulamento de módulos internos. Isso impede que frameworks de Mock (como Mockito) interceptem
chamadas de métodos em classes seladas ou `final` de forma tradicional, a menos que o objeto seja um Mock puro
gerenciado pelo Spring.

### 1.3 Spring Boot 4 (Refatoração de Pacotes)

O `RestTemplateBuilder` e classes relacionadas foram movidos para pacotes focados em "RestClient":

* **Novo Pacote:** `org.springframework.boot.restclient`

---

## 2. Resolução do Erro: `MissingMethodInvocationException`

### O problema

Ao tentar realizar o "stubbing" manual do `RestTemplateBuilder` com Mockito:

```java
// PADRÃO ANTIGO - CAUSA ERRO NO JAVA 25/SPRING 7
when(mockRestTemplateBuilder.build()).

thenReturn(restTemplate);
```

O erro ocorre porque o Spring 7 utiliza classes mais restritas que o Mockito não consegue "espionar" (spy) se forem
instanciadas manualmente com `new`.

### A Solução

Devemos utilizar a infraestrutura nativa do Spring Boot para testes de cliente. O `@RestClientTest` já provê um
`RestTemplateBuilder` configurado para interceptar chamadas via `MockRestServiceServer`.

---

## 3. Padrão de Implementação de Teste (BeerClientMockTest)

Abaixo, o modelo padrão para testes de clientes REST em Spring Boot 4:

```java
package guru.springframework.resttemplate.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import guru.springframework.resttemplate.config.RestTemplateBuilderConfig;
import tools.jackson.core.JacksonException; // Jackson 3
import tools.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

@RestClientTest(BeerClientImpl.class) // Associa automaticamente o Client ao MockServer
@Import(RestTemplateBuilderConfig.class)
class BeerClientMockTest {

  @Autowired
  BeerClient beerClient;

  @Autowired
  MockRestServiceServer server;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  void testListBeers() throws JacksonException {
    String payload = objectMapper.writeValueAsString(getPage());

    server.expect(method(HttpMethod.GET))
      .andExpect(requestTo("/api/v1/beer"))
      .andRespond(withSuccess(payload, MediaType.APPLICATION_JSON));

    var dtos = beerClient.listBeers();
    assertThat(dtos.getContent()).isNotEmpty();
  }
}
```

---

## 4. Configuração do RestTemplate (RestTemplateBuilderConfig)

No Spring 7, a configuração deve seguir o novo namespace de pacotes.

```java
package guru.springframework.resttemplate.config;

import org.springframework.boot.restclient.RestTemplateBuilder; // Novo Pacote
import org.springframework.boot.restclient.autoconfigure.RestTemplateBuilderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateBuilderConfig {

  @Bean
  RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer) {
    // O uso do configurer garante que as propriedades do application.properties 
    // e o suporte a Jackson 3 sejam injetados corretamente
    return configurer.configure(new RestTemplateBuilder())
      .uriTemplateHandler(new DefaultUriBuilderFactory());
  }
}
```

---

## 5. Melhores Práticas de Codificação (Service Layer)

Ao implementar métodos que utilizam `UriComponentsBuilder`, evite erros comuns de "Copy-Paste". Garanta que cada
parâmetro mapeie para sua respectiva variável:

```java
// CORRETO (Spring 7 / Boot 4)
if(pageNumber !=null){
  uriComponentsBuilder.

queryParam("pageNumber",pageNumber); // Não use beerStyle aqui!
}
```

---

## 6. Conclusão e Próximos Passos

1. **Migração de Exceções:** Substitua `JsonProcessingException` por `JacksonException` em toda a base de código.
2. **Injeção de Dependência:** Nunca tente instanciar `RestTemplateBuilder` manualmente em testes; confie no
   `@RestClientTest`.
3. **Modernização:** Para novos projetos, a equipe deve considerar o uso do **`RestClient`** (introduzido no Spring 6.1
   e refinado no 7.0), que oferece uma API fluente superior ao `RestTemplate`.

---

*Documentação atualizada em: Março de 2026*
*Versões Alvo: Java 25 LTS, Spring Boot 4.0.0*