# Spring Boot 4 and Spring Framework 7

Spring 7, Spring Boot 4, Spring MVC, JPA/Hibernate, Mongo, Spring Security, OAuth2 JWT, MySQL, Docker/K8s, Microservices

## Stack Tecnológico de Referência

- **Spring Framework 7** — lançado em **novembro de 2025**
- **Spring Boot 4** — lançado em **novembro de 2025**
- **Java SE 25 (LTS)** — lançado pela **Oracle** em **16 de setembro de 2025**
- **Jackson 3.x** — nova geração da biblioteca de serialização JSON utilizada pelo ecossistema Spring

## Conteúdo do Curso Concluído

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
13. Using Test Testcontainers with Spring Boot
14. CSV File Upload
15. Query Parameters with Spring MVC
16. Paging and Sorting with Spring MVC
17. JPA Database Relationship Mapping
18. Database Transactions & Locking and Spring
19. Introduction to Spring Data REST
20. Spring RestTemplate
21. Testing Spring RestTemplate
22. Spring Security HTTP Basic Auth
23. Spring Authorization Server

---

## Spring Framework & Spring Boot

## Tabela Comparativa Evolutiva

### Evolução do Spring Framework (versões 1 a 7)

| Versão         | Ano (aprox.) | Principais Características                                                       | Contexto / Impacto                                                  |
|----------------|--------------|----------------------------------------------------------------------------------|---------------------------------------------------------------------|
| **Spring 1.x** | 2004–2006    | IoC Container, DI básica, suporte a XML, AOP inicial                             | Revolucionou o Java EE ao reduzir acoplamento e dependência de EJBs |
| **Spring 2.x** | 2006–2009    | Anotações (`@Autowired`, `@Component`), configuração híbrida (XML + annotations) | Tornou o framework mais produtivo e menos verboso                   |
| **Spring 3.x** | 2009–2013    | Java Config (`@Configuration`), REST com `@Controller`, Spring MVC moderno       | Forte adoção de APIs REST e eliminação gradual de XML               |
| **Spring 4.x** | 2013–2016    | Suporte ao Java 8, Lambdas, melhor integração com REST e Web                     | Preparou o ecossistema para aplicações modernas                     |
| **Spring 5.x** | 2017–2022    | Programação reativa (WebFlux), suporte a Kotlin, Java 11+                        | Grande mudança arquitetural com foco em reatividade                 |
| **Spring 6.x** | 2022–2025    | Baseline Java 17, Jakarta EE (jakarta.*), remoção de APIs legadas                | Modernização forçada do ecossistema                                 |
| **Spring 7.x** | 2025+        | Performance, cloud-native, observabilidade, stack moderno                        | Consolidação do Spring como framework enterprise moderno            |

### Evolução do Spring Boot (versões 1 a 4)

| Versão              | Ano (aprox.) | Principais Características                                         | Contexto / Impacto                                     |
|---------------------|--------------|--------------------------------------------------------------------|--------------------------------------------------------|
| **Spring Boot 1.x** | 2014–2017    | Auto Configuration, Starters, Embedded Tomcat                      | Tornou o Spring acessível e extremamente produtivo     |
| **Spring Boot 2.x** | 2018–2022    | Actuator avançado, melhor observabilidade, compatível com Spring 5 | Popularização massiva em microsserviços                |
| **Spring Boot 3.x** | 2022–2024    | Java 17+, Jakarta EE, compatível com Spring 6                      | Atualização obrigatória para manter suporte            |
| **Spring Boot 4.x** | 2024+        | Otimização de startup, cloud-native, observabilidade nativa        | Foco em produção, performance e ambientes distribuídos |

### Relação entre Spring Framework e Spring Boot

| Spring Boot | Spring Framework |
|-------------|------------------|
| Boot 1.x    | Spring 4.x       |
| Boot 2.x    | Spring 5.x       |
| Boot 3.x    | Spring 6.x       |
| Boot 4.x    | Spring 7.x       |

> **Regra Geral:** Spring Boot sempre acompanha a versão principal do Spring Framework

### Resumo

- **Spring Framework** → foco em **conceitos, arquitetura e APIs**
- **Spring Boot** → foco em **produtividade, configuração e runtime**
- Spring Boot **não substitui** o Spring Framework — ele **orquestra** o uso dele