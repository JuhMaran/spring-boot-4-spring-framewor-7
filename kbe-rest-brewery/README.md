# SFG Beer Works - RESTful Brewery Service

## Tecnologias

- Spring Framework 7
- Spring Boot 4.0.5
- Java version "25" 2025-09-16 LTS
- Docker
- Apache Maven 3.9.11

## Dependências

- Spring Web
- Lombok
- Spring boot DevTools
- Spring Data JPA
- Validation
- H2 Database
- MapStruct

## Ferramentas

- IDE IntelliJ IDEA
- Postman
- Docker Desktop

## Documentos

- [SFG Brewery API (1.1)](https://sfg-beer-works.github.io/brewery-api/)

## Comandos

```bash
docker build -f .\src\main\dockerBase\Dockerfile -t kbe-rest .
```

```bash
docker run -p 8080:8080 -d kbe-rest
```

**From layers**

```bash
docker build -f .\src\main\docker\Dockerfile -t kbe-rest .
```

## Exemplo

### cURL - GET `/beer/{beerId}`

```
curl --location 'http://localhost:8080/api/v1/beer/0d772e26-579b-4eed-a65f-119dc0b728c5' \
--header 'Accept: application/json' 
```

### Response Body

```json
{
  "id": "0d772e26-579b-4eed-a65f-119dc0b728c5",
  "beerName": "Mango Bobs",
  "beerStyle": "ALE",
  "upc": "0631234200036",
  "price": 84.12,
  "quantityOnHand": 2794,
  "createdDate": "2026-04-03T23:47:38.197125",
  "lastUpdatedDate": "2026-04-03T23:47:38.197914"
}
```