# Spring 7 - REST MVC

![Java](https://img.shields.io/badge/Java-25-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.4-green)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![License](https://img.shields.io/badge/license-Apache%202.0-blue)

## Descrição

## Funcionalidades

## Pré-requisitos

Antes de iniciar, você precisa ter instalado:

- Java 25
- Maven 3.9+
- Docker Desktop
- Postman
- Conhecimento básico em:
    - Spring Boot
    - Banco de Dados SQL: JPA, H2, Flyway
    - REST APIs
    - Spring Security e OAuth2
    - Docker Compose
    - Kubernetes
    - Testes
    - Apache Kafka
    - Microsserviços
    - Auditoria e Logging
    - Observabilidade
    - Async

## Instalação

```bash
# Clone o repositório
git clone https://github.com/JuhMaran/spring-boot-4-spring-framewor-7.git

# Acesse a pasta do projeto
cd spring-boot-4-spring-framewor-7/spring-7-rest-mvc

# Compile o projeto
mvn clean install

# Execute a aplicação
mvn spring-boot:run
````

A aplicação será iniciada em:

```
http://localhost:8081
```

Base path da API:

```
http://localhost:8081/api/v1
```

## Tecnologias Utilizadas

* Java 25
* Spring Boot 4
* Spring Data JPA
* Spring Data REST
* H2 Database
* Hibernate
* Lombok
* MapStruct
* Spring Actuator

## Como Usar

## Fluxo

## Arquitetura

## Endpoints

| Endpoint                                            | Descrição                  |
|-----------------------------------------------------|----------------------------|
| `/api/v1/beer`                                      | Lista todas as cervejas    |
| `/api/v1/beer/{id}`                                 | Busca cerveja por ID       |
| `/api/v1/beer/search`                               | Lista queries disponíveis  |
| `/api/v1/beer/search/findByUpc`                     | Busca por UPC              |
| `/api/v1/beer/search/findAllByBeerName`             | Busca por nome             |
| `/api/v1/beer/search/findAllByBeerStyle`            | Busca por estilo           |
| `/api/v1/beer/search/findAllByBeerNameAndBeerStyle` | Busca combinada            |
| `/actuator`                                         | Monitoramento da aplicação |

## Documentação e Recursos

Esta seção centraliza links e materiais complementares do projeto.

### Wiki

❌ Não implementado.

### Documentação Externa

- Curso: *Spring Boot 4, Spring Framework 7: Beginner to Guru*

### Repositório

- GitHub: [spring-7-rest-mvc](https://github.com/JuhMaran/spring-boot-4-spring-framewor-7/tree/main/spring-7-rest-mvc)

### Collections (Postman / Insomnia)

❌ Não implementado.

### OpenAPI / Swagger

❌ Não implementado.

### Testes

Testes Unitários e de Integração implementados

### Outros Arquivos Importantes

- `pom.xml` → Gerenciamento de dependências Maven
- `application.yaml` → Configurações da aplicação

## Status do Projeto

🏗️ **Em construção**

## 🤝 Contribuição

Contribuições são sempre bem-vindas!

1. Faça um fork do projeto
2. Crie uma branch:

    ```bash
    git checkout -b minha-feature
    ```

3. Commit suas mudanças:

    ```bash
    git commit -m 'Minha nova feature'
    ```

4. Push:

    ```bash
    git push origin minha-feature
    ```

5. Abra um Pull Request 🚀

## ♿ Acessibilidade

* Diagramas feitos com **Mermaid** (compatível com GitHub)
* Estrutura organizada com títulos claros
* Uso moderado de emojis para melhor leitura visual

## 📄 Licença

Este projeto está licenciado sob a **Apache License 2.0**.

Veja o arquivo [LICENSE](https://www.apache.org/licenses/LICENSE-2.0.txt) para mais detalhes.

## 👩‍💻 Autora

Desenvolvido por **Juh Maran**  
🔗 [https://github.com/JuhMaran](https://github.com/JuhMaran)