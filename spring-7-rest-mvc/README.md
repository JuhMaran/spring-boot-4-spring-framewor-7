# Spring 7 REST MVC

- Spring Web MVC
- Project Lombok
    - POJOs
    - builders
    - Constructors
    - Logging
    - Delombok
- DRY - Don't Repeat Yourself
- DRY Refactoring
- URI Builder
- Java Optional
- Exception Handling
    - Throw custom Exception with Mockito
    - Usando Exception Handler
    - Controller Advice
        - NotFoundException
    - Usando anotação `ResponseStatus`
- Spring Data JPA
- DTO - Data Transfer Objects
- MapStruct

---

## Funcionalidades

### Beer

Path: `/api/v1/beer`
Path ID: `/api/v1/beer/{beerId}`

- GET
    - Get Beer by ID
    - List Beers
- POST
    - handle Post
- PUT
    - Update Beer By ID
- DELETE
    - Delete Beer By ID
- PATCH
    - Update Beer Patch By ID

### Customer

Path: `/api/v1/customer`
Path ID: `/api/v1/customer/{customerId}`

- GET
    - Get Customer by ID
    - List All Customers
- POST
    - handle Post
- PUT
    - Update Customer By ID
- DELETE
    - Delete Customer By ID
- PATCH
    - Update Customer Patch By ID

---

## Exception Handler

---

## Tests

### Spring MockMVC Test with Mockito and JUnit

- Configuração do MockMVC
- Usando JSON

---

## MapStruct – Dependências e Configuração

### Definição de Propriedades

Primeiramente, declaramos uma propriedade para a versão do MapStruct no `pom.xml`, pois ela será utilizada em mais de um
ponto da configuração.

Exemplo atualizado:

```xml

<properties>
    <java.version>25</java.version>
    <lombok.version>1.18.42</lombok.version>
    <org.mapstruct.version>1.7.0.Beta1</org.mapstruct.version>
</properties>
```

Utilizar propriedades permite definir a versão apenas uma vez, facilitando manutenção futura.

### Dependências Necessárias

Devemos adicionar as seguintes dependências:

**Project Lombok**

Biblioteca Java baseada em anotações que reduz código boilerplate, gerando automaticamente:

- Getters e setters
- equals e hashCode
- toString
- Builders
- Construtores

```xml

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>${lombok.version}</version>
    <optional>true</optional>
</dependency>
```

---

**MapStruct Processor**

Processador de anotações responsável por gerar mapeadores type-safe em tempo de compilação.

```xml

<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct-processor</artifactId>
    <version>${org.mapstruct.version}</version>
    <scope>compile</scope>
</dependency>
```

---

**Lombok MapStruct Binding**

Dependência necessária para garantir a compatibilidade entre o MapStruct e o código gerado pelo Lombok.

Sem essa dependência, o MapStruct não conseguirá processar corretamente classes que utilizam Lombok.

```xml

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok-mapstruct-binding</artifactId>
    <version>0.2.0</version>
    <scope>compile</scope>
</dependency>
```

> Essa integração passou a ser necessária a partir de versões mais recentes do Lombok. Documentações antigas podem não
> mencioná-la.

---

## Remoção do `@ExtendWith(MockitoExtension.class)`

Quando usamos: `@WebMvcTest`

O próprio Spring já integra o Mockito automaticamente.
Logo, o `@ExtendWith(MockitoExtension.class)` é redundante e pode ser removido.

---

## Substituição de `.get(0)` por `.getFirst()`

Antes: `beerServiceImpl.listBeers().get(0);`

Depois: `beerServiceImpl.listBeers().getFirst();`

### Por que é melhor?

* Mais legível
* Expressa intenção claramente
* Evita "números mágicos"

---

## Uso de `Map.of()` ao invés de `new HashMap<>()`

Antes:

```
Map<String, Object> beerMap = new HashMap<>();
beerMap.put("beerName", "New Name");
```

Depois:

```
Map<String, Object> beerMap = Map.of("beerName", "New Name");
```

### Benefícios

* Código mais conciso
* Imutável (melhor prática para testes)
* Mais legível

---

## Melhor assert com AssertJ

Antes:

```
assertThat(beerMap.get("beerName"))
    .isEqualTo(beerArgumentCaptor.getValue().getBeerName());
```

Agora:

```
assertThat(beerArgumentCaptor.getValue())
    .extracting(BeerDTO::getBeerName)
    .isEqualTo("New Name");
```

### Vantagens

* Melhor legibilidade
* Evita dependência do Map
* Foca diretamente no objeto capturado
* Mais idiomático com AssertJ

---

## Conceito Importante

Esse teste é um **slice test** com `@WebMvcTest`, ou seja:

* Testa apenas a camada Controller
* O Service é mockado (`@MockitoBean`)
* Usa `MockMvc` para simular requisições HTTP
* Verifica status, headers e JSON retornado

Ele NÃO sobe contexto completo da aplicação.