# Spring 7 - WebClient

## Tecnologias

| Tecnologia                     | Versão  | Lançamento          |
|:-------------------------------|:--------|:--------------------|
| Spring Framework               | 7.x     | nov/2025            |
| Spring Boot                    | 4.0.3   | nov/2025            |
| Java SE                        | 25 LTS  | Oracle — 16/09/2025 |
| Jackson (`tools.jackson.core`) | 3.1.0   | fev/2026            |
| Spring Reactive Web (WebFlux)  | 4.0.3   |                     |
| Project Lombok                 | 1.18.42 |                     |
| Awaitility                     | 4.3.0   |                     | 

---

## Nota de atualização de versão

No ambiente atualizado (**Spring Boot 4 / Spring Framework 7 / WebFlux 4**), foi necessário declarar explicitamente um
**Bean de `WebClient.Builder`** através de uma classe de configuração, por exemplo `WebClientConfig`.

Isso permite que o `WebClient.Builder` seja **injetado corretamente no serviço `BeerClientImpl`** através do construtor.

---

## Endpoints 

Principais operações CRUD utilizando o `WebClient` dentro de uma aplicação Spring WebFlux

| Operação           | Método HTTP | Método no Cliente  |
|--------------------|-------------|--------------------|
| Listar             | GET         | `listBeerDtos()`   |
| Buscar por ID      | GET         | `getBeerById()`    |
| Criar              | POST        | `createBeer()`     |
| Atualizar completo | PUT         | `updateBeer()`     |
| Atualizar parcial  | PATCH       | `patchBeer()`      |
| Remover            | DELETE      | `deleteBeerById()` |
