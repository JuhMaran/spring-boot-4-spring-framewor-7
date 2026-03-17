# Spring 7 Playground - Arquiteturas e Tecnologias

Este repositório reúne diversos projetos independentes com o objetivo de explorar, demonstrar e consolidar conhecimentos
no ecossistema **Spring 7 + Spring Boot 4**, utilizando **Java 25 (LTS)**.

Os projetos fazem parte do curso **"Spring Boot 4, Spring Framework 7: Beginner to Guru" (Udemy)** e evoluem
progressivamente conforme o avanço no conteúdo.

Atualmente, o progresso acompanha todo o roadmap do curso, com módulos sendo implementados gradualmente.

Cada módulo explora uma **tecnologia ou estilo arquitetural específico**, abrangendo aplicações tradicionais, reativas,
segurança, integração e API Gateway.

---

## Conteúdo do Curso

### Fundamentos

1. Introduction
2. Building a Spring Boot Web App
3. Performing Dependency Injection with Spring

---

### Web e APIs REST (Spring MVC)

4. Introduction to RESTful Web Services
5. Using Project Lombok with Spring Boot
6. Spring MVC Rest Services
7. Spring MockMVC Test with Mockito and JUnit
8. Exception Handling with Spring MVC
9. Spring Data JPA with Spring MVC
10. Data Validation with Spring
11. MySQL with Spring Boot
12. Flyway Migrations with Spring Boot
13. Using Testcontainers with Spring Boot
14. CSV File Upload
15. Query Parameters with Spring MVC
16. Paging and Sorting with Spring MVC
17. JPA Database Relationship Mapping
18. Database Transactions, Locking and Spring

---

### Integração e Clientes HTTP

19. Introduction to Spring Data REST
20. Spring RestTemplate
21. Testing Spring RestTemplate

---

### Segurança

22. Spring Security HTTP Basic Auth
23. Spring Authorization Server
24. Spring MVC OAuth2 Resource Server
25. Spring RestTemplate with OAuth2

---

### Programação Reativa (WebFlux)

26. Introduction to Reactive Programming with Spring
27. Spring Data R2DBC
28. Spring WebFlux Rest Services
29. Spring WebFlux WebTestClient
30. Exception Handling with Spring WebFlux
31. Spring Data MongoDB
32. Spring WebFlux.fn REST Services
33. Spring WebClient
34. Spring WebFlux Resource Server
35. Spring WebFlux.fn Resource Server
36. Using OAuth 2.0 with Spring WebClient

---

### Cloud e Gateway

37. Spring Cloud Gateway

---

### Build e Documentação

38. Spring Boot Maven Plugin
39. Spring Boot Gradle Plugin
40. OpenAPI with Spring Boot
41. OpenAPI Validation with RestAssured

---

### Tópicos Avançados

42. Introduction to Spring AI
43. Spring RestClient
44. Spring Boot Actuator
45. Request Logging
46. Caching Data with Spring Framework
47. Spring Application Events for Auditing
48. Using your Spring Boot Skills

---

### Containers e Orquestração

49. Docker with Spring Boot
50. Docker Compose with Spring Boot
51. Kubernetes with Spring Boot

---

### Microservices

52. Introduction to Spring Boot Microservices
53. Spring Boot Microservices with Apache Kafka

---

### Certificação e Boas Práticas

54. Spring Professional Certification Practice Test
55. New Spring Boot 3.4.0 Features
56. Spring Boot Engineering Best Practices

---

### Extras

57. Appendix A: Using GitHub
58. Extra - Introduction to Junie and JetBrains AI
59. Extra - Interviews
60. Extra - Kube by Example - Building Spring Boot Docker Images
61. Extra - Kube by Example - Spring Boot on Kubernetes
62. Extra - Kube by Example - Spring Boot Microservices on Kubernetes

---

## Projetos

| Projeto                                                   | Descrição                                                    | Tecnologias Principais                        |
|-----------------------------------------------------------|--------------------------------------------------------------|-----------------------------------------------|
| [spring-7-webapp](./spring-7-webapp)                      | Aplicação Web tradicional com MVC e renderização server-side | Spring MVC, Thymeleaf, JPA, H2                |
| [spring-7-di](./spring-7-di)                              | Demonstração de Injeção de Dependência (IoC)                 | Spring Core, Mockito, JUnit                   |
| [spring-7-rest-mvc](./spring-7-rest-mvc)                  | API REST completa com arquitetura em camadas                 | Spring MVC, JPA, Flyway, Security, OpenAPI    |
| [sdjpa-spring-data-rest](./sdjpa-springdatarest)          | Exposição automática de repositórios como APIs REST          | Spring Data REST, JPA, H2                     |
| [spring-7-resttemplate](./spring-7-resttemplate)          | Consumo de APIs com cliente HTTP síncrono                    | RestTemplate, RestClient, OAuth2 Client       |
| [spring-7-auth-server](./spring-7-auth-server)            | Servidor de autenticação e autorização OAuth2                | Spring Authorization Server, Security, JDBC   |
| [spring-7-reactive-examples](./spring-7-reactive-example) | Exemplos práticos de programação reativa                     | WebFlux, Reactor, Lombok                      |
| [spring-7-reactive](./spring-7-reactive)                  | Aplicação reativa com persistência relacional                | WebFlux, R2DBC, H2                            |
| [spring-7-reactive-mongo](./spring-7-reactive-mongo)      | Aplicação reativa com persistência NoSQL                     | WebFlux, MongoDB Reactive                     |
| [spring-7-webclient](./spring-7-webclient)                | Consumo de APIs com cliente HTTP reativo                     | WebClient, OAuth2 Client                      |
| [spring-7-gateway](./spring-7-gateway)                    | API Gateway reativo para roteamento e segurança              | Spring Cloud Gateway, OAuth2 Resource Server  |
| [spring-7-gateway-gradle](./spring-7-gateway-gradle)      | API Gateway reativo utilizando build com Gradle              | Spring Cloud Gateway, WebFlux, Gradle, OAuth2 |

---

## Tecnologias Utilizadas

### Core

* Java 25 (LTS)
* Spring Framework 7
* Spring Boot 4

---

### Web

* Spring MVC (modelo tradicional baseado em servlet)
* Spring WebFlux (programação reativa não-bloqueante)
* Thymeleaf (renderização server-side)

---

### Segurança

* Spring Security
* OAuth2 Client
* OAuth2 Resource Server
* OAuth2 Authorization Server

---

### Persistência

#### SQL

* Spring Data JPA
* Spring Data JDBC
* Spring Data R2DBC
* H2 Database
* MySQL
* Flyway (versionamento de banco de dados)

#### NoSQL

* MongoDB Reactive (Spring Data MongoDB)

---

### Integração e Comunicação

* RestTemplate (legado)
* RestClient (abordagem moderna)
* WebClient (cliente reativo)

---

### Cloud & Gateway

* Spring Cloud Gateway
* Spring Cloud Dependencies

---

### Observabilidade

* Spring Boot Actuator

---

### Documentação de APIs

* Springdoc OpenAPI (Swagger)

---

### Testes

* JUnit Jupiter
* Mockito
* AssertJ
* Testcontainers
* Reactor Test
* Awaitility
* Rest Assured
* Swagger Request Validator

---

### Ferramentas e Produtividade

* Lombok
* MapStruct
* Docker Compose Support

---

## Padrões e Abordagens

Este repositório explora diferentes estilos arquiteturais e práticas comuns no desenvolvimento com Spring:

* Arquitetura em camadas (Layered Architecture)
* Construção de APIs RESTful
* Programação reativa (Reactive Streams)
* Integração com bancos SQL e NoSQL
* Segurança baseada em OAuth2 e JWT
* API Gateway e roteamento
* Consumo de APIs síncrono vs reativo

---

## Como executar os projetos

Cada projeto é independente. Para executar:

```bash
cd nome-do-projeto
./mvnw spring-boot:run
```

Ou:

```bash
mvn spring-boot:run
```

---

## Suporte a Docker

Alguns projetos incluem suporte a:

* Docker Compose
* Testcontainers (para testes de integração)

---

## Observações

* Este repositório possui caráter **educacional e evolutivo**
* Os projetos acompanham a progressão do curso e podem sofrer alterações ao longo do tempo
* Algumas implementações apresentam **diferentes abordagens para o mesmo problema** (ex: WebMVC vs WebFlux)
* Inclui tanto **tecnologias modernas** quanto **abordagens ainda utilizadas no mercado**

---

## Autora

**Juh Maran**
🔗 https://github.com/JuhMaran

---

## 📄 Licença

Este projeto está licenciado sob a **Apache License 2.0**.

Este projeto é destinado para **fins educacionais**.