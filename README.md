# Spring Boot 4 & Spring Framework 7

Repositório contendo os projetos desenvolvidos durante o curso **Spring Boot 4 e Spring Framework 7**, explorando desde
os fundamentos do ecossistema Spring até arquiteturas modernas com **microservices, segurança OAuth2, programação
reativa e bancos SQL/NoSQL**.

O objetivo deste repositório é apresentar **exemplos práticos e progressivos**, abordando desenvolvimento backend
moderno utilizando as versões mais recentes da plataforma Java e do ecossistema Spring.

---

## Tecnologias Utilizadas

Todos os projetos deste repositório utilizam tecnologias atualizadas do ecossistema Java:

* **Spring Framework 7** — lançado em **Novembro de 2025**
* **Spring Boot 4** — lançado em **Novembro de 2025**
* **Java SE 25 (LTS)** — lançado pela **Oracle** em **16 de Setembro de 2025**

---

## Stack Tecnológica

As aplicações exploram diferentes partes do ecossistema Spring:

* Spring MVC
* Spring WebFlux
* Spring Data JPA
* Spring Data JDBC
* Spring Data MongoDB
* Spring Security
* OAuth2 Authorization Server
* OAuth2 Resource Server
* REST APIs
* Reactive Programming
* MySQL
* Docker
* Microservices

---

## Projetos

| Project                                                   | Port | Database     | Stack                                         | URL                                                                                                                                                                        |
|-----------------------------------------------------------|------|--------------|-----------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [spring-7-webapp](./spring-7-webapp)                      | 8080 | N/A          | Spring MVC                                    | `/books` and `/authors`                                                                                                                                                    |
| [spring-7-di](./spring-7-di)                              | 8080 | N/A          | Spring Core                                   | `/`                                                                                                                                                                        |
| [spring-7-rest-mvc](./spring-7-rest-mvc)                  | 8081 | MySQL        | Spring MVC                                    | `/api/v1/beer` and `/api/v1/beer/{beerId}`<br>`/api/v1/customer` and `/api/v1/customer/{customerId}`                                                                       |
| [sdjpa-spring-data-rest](./sdjpa-springdatarest)          | 8080 | H2           | Spring Data REST                              | `/api/v1`                                                                                                                                                                  |
| [spring-7-resttemplate](./spring-7-resttemplate)          | 8080 | N/A          | REST Client (RestTemplate)                    | `/api/v1/beer` and `/api/v1/beer/{beerId}`                                                                                                                                 |
| [spring-7-auth-server](./spring-7-auth-server)            | 9000 | N/A          | Spring Security / OAuth2 Authorization Server | Redirect URI:<br>`http://127.0.0.1:8080/login/oauth2/code/oidc-client`<br>`http://127.0.0.1:8080/authorized`<br>Logout:<br>`http://127.0.0.1:8080/`<br>Login URL: `/login` |
| [spring-7-reactive-examples](./spring-7-reactive-example) | 8080 | N/A          | Spring WebFlux                                | `/`                                                                                                                                                                        |
| [spring-7-reactive](./spring-7-reactive)                  | 8082 | H2 In Memory | Spring WebFlux                                | `/api/v2/beer` and `/api/v2/beer/{beerId}`<br>`/api/v2/customer` and `/api/v2/customer/{customerId}`                                                                       |
| [spring-7-reactive-mongo](./spring-7-reactive-mongo)      | 8083 | MongoDB      | Spring WebFlux.fn                             | `/api/v3/beer` and `/api/v3/beer/{beerId}`<br>`/api/v3/customer` and `/api/v3/customer/{customerId}`                                                                       |
| [spring-7-webclient](./spring-7-webclient)                | 8080 | N/A          | REST Client (WebClient)                       | `/api/v3/beer` and `/api/v3/beer/{beerId}`<br>`/api/v3/customer` and `/api/v3/customer/{customerId}`                                                                       |
| API Gateway                                               | 8080 | N/A          | Spring Cloud Gateway                          | Root: `/` (roteamento para `/api/v1`, `/api/v2`, `/api/v3`)                                                                                                                |

---

## Diagrama de Arquitetura

```mermaid
flowchart LR
    Client[Client]
    Gateway[Spring Cloud Gateway - 8080]
    Auth[Spring Auth Server - 9000]
    MVC[Spring MVC Service - 8081]
    MySQL[(MySQL)]
    WebFlux[Spring WebFlux Service - 8082]
    H2[(H2 In Memory)]
    WebFluxFN[Spring WebFlux.fn Service - 8083]
    Mongo[(MongoDB)]
    Client --> Gateway
    Gateway --> Auth
    Gateway --> MVC
    Gateway --> WebFlux
    Gateway --> WebFluxFN
    MVC --> MySQL
    WebFlux --> H2
    WebFluxFN --> Mongo
```

---

## Maven

Todos os projetos são construídos utilizando **Apache Maven**.

Cada projeto utiliza **pelo menos duas das dependências abaixo**.

---

## Dependências

| Categoria           | Dependências                                                                              |
|---------------------|-------------------------------------------------------------------------------------------|
| **Developer Tools** | Lombok<br>Spring Boot DevTools<br>Spring Docker Compose                                   |
| **Web**             | Spring Web MVC<br>Spring Reactive Web (WebFlux)                                           |
| **Operations**      | Spring Boot Actuator                                                                      |
| **SQL**             | Spring Data JPA<br>Spring Data JDBC<br>H2 Database<br>MySQL Driver<br>Flyway Migration    |
| **NoSQL**           | Spring Data Reactive MongoDB                                                              |
| **I/O**             | Validation                                                                                |
| **Security**        | Spring Security<br>OAuth2 Client<br>OAuth2 Resource Server<br>OAuth2 Authorization Server |
| **Testing**         | Testcontainers (JUnit Jupiter, MySQL, MongoDB)                                            |

---

## Bibliotecas Adicionais

| Biblioteca          | Descrição                                                             |
|---------------------|-----------------------------------------------------------------------|
| **MapStruct 1.6.3** | Code generator para mapeamento de DTOs                                |
| **Jackson 3.x**     | Nova geração da biblioteca de serialização JSON do ecossistema Spring |
| **OpenCSV**         | Processamento de arquivos CSV                                         |
| **Awaitility**      | Testes assíncronos                                                    |

---

## Plugins Maven

| Plugin                   | Versão     |
|--------------------------|------------|
| Maven Compiler Plugin    | **3.14.1** |
| Maven Failsafe Plugin    | **3.5.2**  |
| Lombok MapStruct Binding | **0.2.0**  |

---

## Conteúdo do Curso

O curso cobre os seguintes tópicos:

1. Introduction
2. Building a Spring Boot Web App
3. Performing Dependency Injection with Spring
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
19. Introduction to Spring Data REST
20. Spring RestTemplate
21. Testing Spring RestTemplate
22. Spring Security HTTP Basic Auth
23. Spring Authorization Server
24. Spring MVC OAuth2 Resource Server
25. Spring RestTemplate with OAuth2
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
37. Spring Cloud Gateway
38. Spring Boot Maven Plugin
39. Spring Boot Gradle Plugin
40. OpenAPI with Spring Boot
41. OpenAPI Validation with RestAssured
42. Introduction to Spring AI
43. Spring RestClient
44. Spring Boot Actuator
45. Request Logging
46. Caching Data with Spring Framewokr
47. Spring Application Events for Auditing
48. Using your Spring Boot Skills
49. Docker with Spring Boot
50. Docker Compose with Spring Boot
51. Kubernetes with Spring Boot
52. Introduction to Spring Boot Microservices
53. Spring Boot Microservices with Apache Kafka
54. Spring Professional Certification Practice Test
55. New Spring Boot 3.4.0 Features
56. Spring Boot Engineering Best Practices
57. Appendix A: Using GitHub
58. Extra - Introduction to Junie and JetBrains AI
59. Extra - Interviews
60. Extra - Kube by Example - Building Spring Boot Docker Images
61. Extra - Kube by Example - Spring Boot on Kubernetes
62. Extra - Kube by Example - Spring Boot Microservices on Kubernetes

---

## OAuth2 Configuration

### Root URL

| Property | Value                   |
|----------|-------------------------|
| Root URL | `http://localhost:8080` |

---

### OAuth2 Client Provider

(`spring.security.client.provider`)

| Property          | Value                                    |
|-------------------|------------------------------------------|
| Authorization URI | `http://localhost:9000/oauth2/authorize` |
| Token URI         | `http://localhost:9000/oauth2/token`     |

---

### OAuth2 Resource Server

(`spring.security.oauth2.resourceserver`)

| Property       | Value                   |
|----------------|-------------------------|
| JWT Issuer URI | `http://localhost:9000` |

---

### Client Registration

(`spring.security.client.registration`)

| Property                 | Value                        |
|--------------------------|------------------------------|
| Provider                 | `springauth`                 |
| Client ID                | `oidc-client`                |
| Client Secret            | `secret`                     |
| Authorization Grant Type | `client_credentials`         |
| Scope                    | `message.read message.write` |

---

# Skills e Tecnologias

### Core

![Java](https://img.shields.io/badge/Java-25_LTS-orange)
![Spring](https://img.shields.io/badge/Spring_Framework_7-6DB33F)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_4-6DB33F)
![Spring MVC](https://img.shields.io/badge/Spring-MVC-6DB33F)
![Spring WebFlux](https://img.shields.io/badge/Spring-WebFlux-6DB33F)
![Spring Security](https://img.shields.io/badge/Spring-Security-6DB33F)

### APIs & Architecture

![REST](https://img.shields.io/badge/API-REST-blue)
![Reactive](https://img.shields.io/badge/Reactive-Programming-blue)
![Microservices](https://img.shields.io/badge/Microservices-Architecture-blue)
![Spring Cloud Gateway](https://img.shields.io/badge/Spring_Cloud-Gateway-blue)
![OAuth2](https://img.shields.io/badge/OAuth2-Authorization_Server-red)
![OAuth2 Resource Server](https://img.shields.io/badge/OAuth2-Resource_Server-red)

### Data

![Spring Data JPA](https://img.shields.io/badge/Spring_Data-JPA-6DB33F)
![Spring Data JDBC](https://img.shields.io/badge/Spring_Data-JDBC-6DB33F)
![Spring Data MongoDB](https://img.shields.io/badge/Spring_Data-MongoDB-6DB33F)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1)
![MongoDB](https://img.shields.io/badge/MongoDB-Database-47A248)
![H2](https://img.shields.io/badge/H2-Database-09476B)

### Build, DevOps & Tools

[![Tools](https://skillicons.dev/icons?i=maven,docker,idea,git,github,md)](https://skillicons.dev)

![Docker Compose](https://img.shields.io/badge/Docker-Compose-2496ED)
![Kubernetes](https://img.shields.io/badge/Kubernetes-326CE5)
![Flyway](https://img.shields.io/badge/Flyway-Database_Migration-CC0200)

### Testing

![JUnit](https://img.shields.io/badge/JUnit-Jupiter-green)
![Testcontainers](https://img.shields.io/badge/Testcontainers-Docker-green)
![Awaitility](https://img.shields.io/badge/Awaitility-Async_Testing-green)

### Libraries

![MapStruct](https://img.shields.io/badge/MapStruct-1.6.3-blue)
![Jackson](https://img.shields.io/badge/Jackson-3.x-blue)
![OpenCSV](https://img.shields.io/badge/OpenCSV-CSV-blue)

---

# Objetivo do Repositório

Este repositório tem como objetivo:

* Demonstrar **boas práticas no desenvolvimento com Spring**
* Explorar **novas features do Spring Framework 7**
* Apresentar **Spring Boot 4 com Java 25**
* Servir como **material de referência para estudos**
* Fornecer **exemplos práticos de APIs modernas**

---

# Licença

Este projeto é destinado para **fins educacionais**.
