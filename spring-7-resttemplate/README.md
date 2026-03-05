# Spring 7 - RestTemplate

## Nota Técnica

**Escopo:** Esta documentação orienta a padronização e migração de testes de integração para clientes REST considerando
a atualização do stack tecnológico adotado pela equipe.

### Stack Tecnológico de Referência

* **Spring Framework 7** — lançado em **novembro de 2025**
* **Spring Boot 4** — lançado em **novembro de 2025**
* **Java SE 25 (LTS)** — lançado pela **Oracle** em **16 de setembro de 2025**
* **Jackson 3.x** — nova geração da biblioteca de serialização JSON utilizada pelo ecossistema Spring

### Pontos-chave da Atualização

* **Jackson 3.x:** O namespace foi alterado para `tools.jackson.*`, exigindo atualização de imports. A exceção base
  passou a ser `JacksonException`, substituindo `JsonProcessingException`. Métodos legados como `asText()` foram
  substituídos por `asString()`.

* **Modelo `JsonNode`:** A API foi modernizada. Estruturas agora são iteráveis diretamente e métodos antigos como
  `elements()` foram removidos ou substituídos.

* **Java 25 (Encapsulamento Forte):** O reforço no encapsulamento de módulos pode limitar técnicas tradicionais de
  *mocking*, especialmente em classes `final` ou seladas. Recomenda-se utilizar a infraestrutura de testes fornecida
  pelo Spring.

* **Refatoração no Spring Boot:** Componentes relacionados a clientes HTTP foram reorganizados no pacote
  `org.springframework.boot.restclient`.

* **Padrão de Testes:** Para testes de clientes REST, recomenda-se utilizar `@RestClientTest` em conjunto com
  `MockRestServiceServer`, evitando *stubbing* manual de `RestTemplateBuilder`.

* **Configuração HTTP:** A criação do `RestTemplateBuilder` deve utilizar `RestTemplateBuilderConfigurer` para preservar
  as auto-configurações do Spring Boot.

* **Boas práticas de URI:** Ao utilizar `UriComponentsBuilder`, garantir que cada parâmetro esteja corretamente
  associado à sua variável para evitar erros de implementação.

* **Evolução da API HTTP:** Para novos desenvolvimentos, considerar o uso do **`RestClient`**, que oferece uma API mais
  moderna e fluente em relação ao `RestTemplate`.

### Recomendação

Durante o processo de migração, recomenda-se revisar:

* **imports e namespaces**
* **tratamento de exceções**
* **APIs removidas ou renomeadas**
* **estratégia de testes de integração**

O alinhamento com as práticas recomendadas pelo ecossistema Spring garante maior compatibilidade com as versões atuais e
futuras do framework.

---