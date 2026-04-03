# Junie and JetBrains AI

## Tecnologias

- Java 25 LTS
- Spring Framework 7
- Spring Boot 4
- Spring Web
- Lombok
- Spring Data JPA
- H2 Database
- Flyway Migration
- Validation
- Junie

## Importante

No curso, o instrutor demonstra a utilização do Junie, ferramenta de IA da JetBrains. Entretanto, não possuo mais acesso à versão trial. Diante disso, optei por instalar o agente Codex (ChatGPT) como alternativa para acompanhar o conteúdo apresentado.

## Prompts

### Prompt 1 - Criação da Entidade JPA

Crie uma nova entidade JPA no pacote `guru.springframework.juniemvc.entities` chamada `Beer`. A entidade JPA deve utilizar os recursos do Project Lombok: `Getter`, `Setter`, `Builder`, `NoArgsConstructor` e `AllArgsConstructor`. Utilize `Integer` para os campos `id` e `version`. Adicione as propriedades `String beerName`, `String beerStyle`, `String upc`, `Integer quantityOnHand`, `BigDecimal price`, além das propriedades JPA `createdDate` e `updateDate` utilizando `LocalDateTime`.

### Prompt 2 - Anotações JPA para Auditoria

Anote os campos `createdDate` e `updateDate` com anotações JPA apropriadas.

### Prompt 3 - Repositório JPA e Testes de CRUD

No pacote `repositories`, crie um repositório Spring Data JPA para a entidade `Beer`. Crie um teste para validar as operações básicas de CRUD utilizando o repositório da entidade JPA `Beer`. Verifique se os testes estão sendo executados com sucesso.

### Prompt 4 - Controller, Service e Testes com MockMVC

No pacote `controllers`, crie um novo Controller Spring MVC para a entidade `Beer`. Adicione operações para criação, busca por id e listagem de todos os registros.

No pacote `services`, crie uma interface de serviço e sua implementação. Adicione os métodos necessários para suportar as operações do controller utilizando o Spring Data Repository.

O controller deve utilizar apenas o serviço, e o serviço deve utilizar o repositório Spring Data JPA para as operações de persistência.

Crie testes com Spring MockMVC para as operações do controller. Verifique se os testes estão sendo executados com sucesso.

