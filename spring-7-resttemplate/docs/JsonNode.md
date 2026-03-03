# JsonNode

O problema que você está enfrentando ocorre porque a **Jackson 3.0** (incluída no Spring Boot 4 / Spring 7) introduziu
mudanças significativas na API para tornar o modelo de árvore (`JsonNode`) mais consistente e moderno.

Com base no código e na versão **3.0.4** que você está utilizando, aqui estão as causas e as correções:

### 1. Remoção do método `.elements()`

Na Jackson 3.x, o método `elements()` foi removido ou renomeado para seguir padrões mais claros. Agora, a classe
`JsonNode` implementa diretamente `Iterable<JsonNode>`.

- **Causa:** O método `elements()` não existe mais na classe `JsonNode`.
- **Solução:** Você pode usar o método `.values()` ou iterar diretamente sobre o nó (já que ele é um `Iterable`).

### 2. Depreciação e Remoção de `.asText()`

Como indicado no próprio código-fonte da biblioteca que você postou (`@Deprecated // since 3.0`), o método `asText()`
foi substituído por `asString()`. Em versões finais como a 3.0.4, métodos marcados como "deprecated" em RCs anteriores
costumam ser removidos ou tornados inacessíveis para forçar a migração.

- **Causa:** Uso de método legado.
- **Solução:** Use `.asString()`.

### 3. Erro em `.get(String)`

O erro "Cannot resolve method 'get(String)'" dentro do seu lambda acontece por **efeito cascata**. Como o compilador não
reconhece o método `.elements()`, ele perde a inferência de tipo do objeto `node` dentro do `forEachRemaining`. Para o
compilador, `node` torna-se um tipo desconhecido ou `Object`, e por isso ele não encontra o método `.get()`.

---

### Código Corrigido

Aqui está como o seu método `listBeers()` deve ficar na versão 3.0.4:

```java

@Override
public Page<BeerDTO> listBeers() {
  RestTemplate restTemplate = restTemplateBuilder.build();

  // ... (restante do código de resposta)

  ResponseEntity<JsonNode> jsonResponse =
    restTemplate.getForEntity(BASE_URL + GET_BEER_PATH, JsonNode.class);

  if (jsonResponse.getBody() != null) {
    // Na Jackson 3, use .path() para segurança e .forEach() direto no nó
    // ou .values() se quiser ser explícito.
    jsonResponse.getBody().path("content")
      .forEach(node -> {
        // .path() é preferível a .get() pois nunca retorna null (evita NPE)
        // .asString() é o novo padrão para Jackson 3.x
        System.out.println(node.path("beerName").asString());
      });
  }

  System.out.println(stringResponse.getBody());
  return null;
}
```

### Resumo das mudanças na Jackson 3.0.4 para `JsonNode`:

| Método Antigo (2.x) | Método Novo (3.x) | Descrição                                                  |
|:--------------------|:------------------|:-----------------------------------------------------------|
| `.elements()`       | `.values()`       | Retorna os elementos de um array.                          |
| `.fields()`         | `.properties()`   | Retorna os campos de um objeto (Map.Entry).                |
| `.asText()`         | `.asString()`     | Converte o valor para String com coerção.                  |
| `.textValue()`      | `.stringValue()`  | Retorna a String apenas se o nó for textual (sem coerção). |
| `.isTextual()`      | `.isString()`     | Verifica se o tipo é String.                               |

### Dica Adicional (Spring Boot 4)

Já que você está no Spring Boot 4 (Novembro/2025), considere utilizar o **`RestClient`** em vez do `RestTemplate`. O
`RestTemplate` entrou em modo de manutenção e o `RestClient` oferece uma API fluente muito mais moderna e integrada
nativamente com as novas bibliotecas de serialização.