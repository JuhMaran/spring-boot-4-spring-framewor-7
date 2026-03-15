# Spring Boot 4 & Spring Framework 7

Repositório contendo os projetos desenvolvidos durante o curso **Spring Boot 4 e Spring Framework 7**, explorando desde os fundamentos do ecossistema Spring até arquiteturas modernas com **microservices, segurança OAuth2, programação reativa e bancos SQL/NoSQL**.

O objetivo deste repositório é apresentar **exemplos práticos e progressivos**, abordando desenvolvimento backend moderno utilizando as versões mais recentes da plataforma Java e do ecossistema Spring.

# Tecnologias Utilizadas

Todos os projetos deste repositório utilizam tecnologias atualizadas do ecossistema Java:

- **Spring Framework 7** — lançado em **Novembro de 2025**
- **Spring Boot 4** — lançado em **Novembro de 2025**
- **Java SE 25 (LTS)** — lançado pela **Oracle** em **16 de Setembro de 2025**

# Stack Tecnológica

As aplicações exploram diferentes partes do ecossistema Spring:

- Spring MVC
- Spring WebFlux
- Spring Data JPA
- Spring Data JDBC
- Spring Data MongoDB
- Spring Security
- OAuth2 Authorization Server
- OAuth2 Resource Server
- REST APIs
- Reactive Programming
- MySQL
- Docker
- Microservices

# Maven

Todos os projetos são construídos utilizando **Apache Maven**.

## Dependências

Cada projeto utiliza **pelo menos duas das dependências abaixo**.

### Developer Tools
- Lombok
- Spring Boot DevTools
- Spring Docker Compose

### Web
- Spring Web MVC
- Spring Reactive Web (WebFlux)

### Operations
- Spring Boot Actuator

### SQL
- Spring Data JPA
- Spring Data JDBC
- H2 Database
- MySQL Driver
- Flyway Migration

### NoSQL
- Spring Data Reactive MongoDB

### I/O
- Validation

### Security
- Spring Security
- OAuth2 Client
- OAuth2 Resource Server
- OAuth2 Authorization Server

### Testing
- Testcontainers
    - JUnit Jupiter
    - MySQL
    - MongoDB

### Outras Bibliotecas
- **MapStruct 1.6.3** (Nov/2024)
- **Jackson 3.x** — nova geração da biblioteca de serialização JSON do ecossistema Spring
- OpenCSV
- Awaitility (Testing)

## Plugins Maven

- Maven Compiler Plugin — **3.14.1**
- Maven Failsafe Plugin — **3.5.2**
- Lombok MapStruct Binding — **0.2.0**

# Projetos

Lista de projetos incluídos neste repositório:

| Projeto | Descrição |
|------|------|
| [Spring 7 - Web App](./spring-7-webapp) | Aplicação web básica com Spring Boot |
| [Spring 7 - DI](./spring-7-di) | Demonstração de Dependency Injection |
| [Spring 7 - REST MVC](./spring-7-rest-mvc) | Criação de APIs REST utilizando Spring MVC |
| [SDJPA Spring Data REST](./sdjpa-springdatarest) | APIs automáticas com Spring Data REST |
| [Spring 7 - RestTemplate](./spring-7-resttemplate) | Consumo de APIs REST |
| [Spring 7 - Auth Server](./spring-7-auth-server) | OAuth2 Authorization Server |
| [Spring 7 - Reactive Examples](./spring-7-reactive-example) | Exemplos de programação reativa |
| [Spring 7 - Reactive](./spring-7-reactive) | APIs reativas com WebFlux |
| [Spring 7 - Reactive MongoDB](./spring-7-reactive-mongo) | Integração com MongoDB reativo |
| [Spring 7 - WebClient](./spring-7-webclient) | Cliente HTTP reativo |

# Conteúdo do Curso

O curso cobre os seguintes tópicos:

### Fundamentos

1. Introduction
2. Building a Spring Boot Web App
3. Performing Dependency Injection with Spring
4. Introduction to RESTful Web Services
5. Using Project Lombok with Spring Boot

### APIs REST com Spring MVC

6. Spring MVC Rest Services
7. Spring MockMVC Test with Mockito and JUnit
8. Exception Handling with Spring MVC
9. Spring Data JPA with Spring MVC
10. Data Validation with Spring

### Banco de Dados

11. MySQL with Spring Boot
12. Flyway Migrations with Spring Boot
13. Using Testcontainers with Spring Boot
14. CSV File Upload
15. Query Parameters with Spring MVC
16. Paging and Sorting with Spring MVC
17. JPA Database Relationship Mapping
18. Database Transactions, Locking and Spring

### Spring Data

19. Introduction to Spring Data REST

### Integração entre APIs

20. Spring RestTemplate
21. Testing Spring RestTemplate

### Segurança

22. Spring Security HTTP Basic Auth
23. Spring Authorization Server
24. Spring MVC OAuth2 Resource Server
25. Spring RestTemplate with OAuth2

### Programação Reativa

26. Introduction to Reactive Programming with Spring
27. Spring Data R2DBC
28. Spring WebFlux Rest Services
29. Spring WebFlux WebTestClient
30. Exception Handling with Spring WebFlux
31. Spring Data MongoDB
32. Spring WebFlux.fn REST Services
33. Spring WebClient

# Skills e Tecnologias

[![My Skills](https://skillicons.dev/icons?i=java,spring&theme=light)](https://skillicons.dev)

[![My Skills](https://skillicons.dev/icons?i=mysql,hibernate,mongodb&theme=light)](https://skillicons.dev)

[![My Skills](https://skillicons.dev/icons?i=idea,docker,maven,git,github,md&theme=light)](https://skillicons.dev)

# Objetivo do Repositório

Este repositório tem como objetivo:

- Demonstrar **boas práticas no desenvolvimento com Spring**
- Explorar **novas features do Spring Framework 7**
- Apresentar **Spring Boot 4 com Java 25**
- Servir como **material de referência para estudos**
- Fornecer **exemplos práticos de APIs modernas**

# Licença

Este projeto é destinado para **fins educacionais**.