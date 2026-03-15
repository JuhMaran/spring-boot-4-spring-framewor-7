# Spring 7 - Reactive Mongo

## Tecnologias

- Spring Framework 7 (Nov/2025)
- Spring Boot 4 (Nov/2025)
- Java SE 25 LTS (Oracle — 16/09/2025)
- Spring Reactive Web (WebFlux) 4.0.3
- Spring Data Mongo Reactive (NoSQL)
- Validation (I/O)
- Docker Compose Support (Developer Tools)
- Project Lombok 1.18.42 (Developer Tools)
- MapStruct 1.6.3 (Nov/2024)
- Testcontainers (Testing)
- Awaitility
- Jackson 3.1.0 (tools.jackson.core) (Feb/2026)

---

## Endpoints - /beer

| Method | URL                   | Status Code - Success | Status Code - Error                |
|:-------|:----------------------|:----------------------|:-----------------------------------|
| GET    | /api/v3/beer          | 200 OK                | -                                  |
| GET    | /api/v3/beer/{beerId} | 200 OK                | 404 Not Found                      |
| POST   | /api/v3/beer          | 201 Created           | 400 Bad Request                    |
| PUT    | /api/v3/beer/{beerId} | 204 No Content        | 400 Bad Request <br> 404 Not Found |
| PATCH  | /api/v3/beer/{beerId} | 204 No Content        | 400 Bad Request <br> 404 Not Found |
| DELETE | /api/v3/beer/{beerId} | 204 No Content        | 404 Not Found                      |

---

## Endpoints - /customer

| Method | URL                           | Status Code - Success | Status Code - Error                |
|:-------|:------------------------------|:----------------------|:-----------------------------------|
| GET    | /api/v3/customer              | 200 OK                | -                                  |
| GET    | /api/v3/customer/{customerId} | 200 OK                | 404 Not Found                      |
| POST   | /api/v3/customer              | 201 Created           | 400 Bad Request                    |
| PUT    | /api/v3/customer/{customerId} | 204 No Content        | 400 Bad Request <br> 404 Not Found |
| PATCH  | /api/v3/customer/{customerId} | 204 No Content        | 400 Bad Request <br> 404 Not Found |
| DELETE | /api/v3/customer/{customerId} | 204 No Content        | 404 Not Found                      |

---

## Nota de Atualização de Versão (Spring Boot 4 / Spring Framework 7)

Na implementação atual utilizando **Spring Boot 4**, o starter de segurança para Resource Server possui o artefato:

`spring-boot-starter-security-oauth2-resource-server`

Essa alteração reflete ajustes na organização dos starters introduzidos nas versões mais recentes do ecossistema Spring.
Entretanto, funcionalmente, o objetivo permanece o mesmo: **habilitar suporte ao OAuth2 Resource Server no Spring
Security**.

---

## Documentação - Wiki

- [Uso de Comandos MongoDB em Ambiente Docker](https://github.com/JuhMaran/spring-boot-4-spring-framewor-7/wiki/Technical-Guide:-Using-MongoDB-Commands-in-a-Docker-Environment)
- [Configuração do Spring com MongoDB usando MongoDB Compass](https://github.com/JuhMaran/spring-boot-4-spring-framewor-7/wiki/Spring-MongoDB-Config)
- [Collection Postman](../docs/postman_collection/V02_SFG_Brewery_API.postman_collection.json)