# Spring 7 - Reactive Mongo

## Tecnologias

- Spring Framework 7 (Nov/2025)
- Spring Boot 4 (Nov/2025)
- Java SE 25 LTS (Oracle — 16/09/2025)
- Jackson 3.1.0 (tools.jackson.core) (Feb/2026)
- MapStruct 1.6.3 (Nov/2024)
- Spring Reactive Web (WebFlux) 4.0.3
- Spring Data Mongo Reactive
- Spring Validation
- Project Lombok 1.18.42

---

## Endpoints

| Method | URL                   | Status Code - Success | Status Code - Error                |
|:-------|:----------------------|:----------------------|:-----------------------------------|
| GET    | /api/v3/beer          | 200 OK                | -                                  |
| GET    | /api/v3/beer/{beerId} | 200 OK                | 404 Not Found                      |
| POST   | /api/v3/beer          | 201 Created           | 400 Bad Request                    |
| PUT    | /api/v3/beer/{beerId} | 204 No Content        | 400 Bad Request <br> 404 Not Found |
| PATCH  | /api/v3/beer/{beerId} | 204 No Content        | 400 Bad Request <br> 404 Not Found |
| DELETE | /api/v3/beer/{beerId} | 204 No Content        | 404 Not Found                      |

---

## Exemplo de Document

```json
{
  "_id": {
    "$oid": "69b421cc9141b006697c3a5d"
  },
  "beerName": "Galaxy Cat",
  "beerStyle": "Pale Ale",
  "upc": "12356",
  "quantityOnHand": 122,
  "price": {
    "$numberDecimal": "12.99"
  },
  "createdDate": {
    "$date": "2026-03-13T14:40:12.803Z"
  },
  "lastModifiedDate": {
    "$date": "2026-03-13T14:40:12.803Z"
  },
  "_class": "guru.springframework.spring7reactivemongo.domain.Beer"
}
```

---

## Documentação - Wiki

- [Uso de Comandos MongoDB em Ambiente Docker](https://github.com/JuhMaran/spring-boot-4-spring-framewor-7/wiki/Technical-Guide:-Using-MongoDB-Commands-in-a-Docker-Environment)
- [Configuração do Spring com MongoDB usando MongoDB Compass](https://github.com/JuhMaran/spring-boot-4-spring-framewor-7/wiki/Spring-MongoDB-Config)