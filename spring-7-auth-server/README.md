# 🔐 Auth Service - Spring 7 Authorization Server

![Java](https://img.shields.io/badge/Java-25-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.4-brightgreen)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![License](https://img.shields.io/badge/license-Apache%202.0-blue)

## 📌 Descrição

O **Auth Service** é um servidor de autorização baseado em **Spring Boot 4 + Spring Security 7**, responsável por
autenticação e emissão de tokens OAuth2/OpenID Connect.

Este projeto foi criado com o objetivo de demonstrar a configuração moderna do **Authorization Server**, seguindo o novo
modelo baseado em DSL explícita (sem `applyDefaultSecurity()`).

## 🚀 Funcionalidades

- 🔐 Autenticação de usuários com Spring Security
- 🎫 Emissão de tokens OAuth2 (`access_token`)
- 🔄 Suporte a múltiplos grant types:
    - Authorization Code
    - Client Credentials
    - Refresh Token
- 👤 Usuário em memória (InMemory)
- 🧾 Cliente OAuth2 configurado em memória
- 🔑 Geração de chaves RSA para assinatura JWT
- 📊 Monitoramento via Actuator
- 🧪 Ambiente de testes configurado

## 📋 Pré-requisitos

Antes de iniciar, você precisa ter instalado:

- ☕ Java 25
- 📦 Maven 3.9+
- 🧠 Conhecimento básico em:
    - Spring Boot
    - OAuth2 / OpenID Connect

## ⚙️ Instalação

```bash
# Clone o repositório
git clone https://github.com/JuhMaran/spring-boot-4-spring-framewor-7.git

# Acesse a pasta
cd spring-boot-4-spring-framewor-7/spring-7-auth-server

# Compile o projeto
mvn clean install

# Execute a aplicação
mvn spring-boot:run
````

A aplicação será iniciada em:

```
http://localhost:9000
```

## 🧰 Tecnologias Utilizadas

* Java 25
* Spring Boot 4
* Spring Security 7
* Spring Authorization Server
* Spring Data JDBC
* H2 Database
* Maven

## 🧪 Como Usar

### 🔍 Verificar Actuator

```bash
curl http://localhost:9000/actuator
```

### 🔑 Obter Token (Client Credentials)

```bash
curl --location 'http://localhost:9000/oauth2/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Authorization: Basic b2lkYy1jbGllbnQ6c2VjcmV0' \
--data-urlencode 'grant_type=client_credentials' \
--data-urlencode 'scope=message.read message.write'
```

### 👤 Credenciais padrão

| Tipo   | Valor       |
|--------|-------------|
| User   | user        |
| Senha  | password    |
| Client | oidc-client |
| Secret | secret      |

## 🧭 Fluxo de Autenticação

```mermaid
sequenceDiagram
    participant Client
    participant AuthServer
    participant User
    Client ->> AuthServer: Request Token
    AuthServer ->> User: Autenticação (login)
    User -->> AuthServer: Credenciais
    AuthServer -->> Client: Access Token (JWT)
```

## 🏗️ Arquitetura de Segurança

```mermaid
flowchart TD
    A[Request] --> B{Security Filter Chain}
    B -->|Actuator| C[Permit All]
    B -->|OAuth2 Endpoints| D[Authorization Server]
    B -->|Outros| E[Form Login]
    D --> F[JWT Token]
```

## 📊 Endpoints Importantes

| Endpoint        | Descrição               |
|-----------------|-------------------------|
| `/actuator`     | Monitoramento           |
| `/oauth2/token` | Geração de token        |
| `/login`        | Autenticação do usuário |

## 📌 Status do Projeto

🚧 Em desenvolvimento

## 🤝 Contribuição

Contribuições são bem-vindas! 💡

1. Faça um fork do projeto
2. Crie uma branch:
    ```bash
    git checkout -b minha-feature
    ```
3. Commit suas alterações:
    ```bash
    git commit -m "feat: minha contribuição"
    ```
4. Envie para o repositório:
    ```bash
    git push origin minha-feature
    ```
5. Abra um Pull Request 🚀

## ♿ Acessibilidade

* Diagramas feitos com **Mermaid** para melhor leitura no GitHub
* Estrutura organizada com headings semânticos
* Uso moderado de emojis para apoio visual

## 📄 Licença

Este projeto está licenciado sob a **Apache License 2.0**.

Veja o arquivo [LICENSE](https://www.apache.org/licenses/LICENSE-2.0.txt) para mais detalhes.

## 👩‍💻 Autora

Desenvolvido por **Juh Maran**  
🔗 [https://github.com/JuhMaran](https://github.com/JuhMaran)
