# Docker and Kubernetes

## Tecnologias

- Oracle Java 25 JDK
- IntelliJ IDEA
- Maven 3.9.9+
- Gradle
- Git

## Ordem de Execução

### 1. Subir o Authorization Server

```shell
docker run --name auth-server -h auth-server -d -p 9000:9000 spring-7-auth-server:0.0.1-SNAPSHOT
 ```

- Ele emite os tokens
- Precisa estar disponível antes de qualquer outro serviço

### 2. Subir o Resource Server (REST API)

```shell
docker run --name rest-mvc -d -p 8081:8080 -e SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER_URI=http://auth-server:9000 --link auth-server:auth-server spring-7-rest-mvc:0.0.1-SNAPSHOT
```

- Depende do `auth-server`
- Valida o token JWT

### 3. Subir o Gateway

```shell
docker run --name gateway -d -p 8080:8080 -e SPRING_PROFILES_ACTIVE=docker --link auth-server:auth-server --link rest-mvc:rest-mvc spring-7-gateway:0.0.1-SNAPSHOT

docker run --name gateway -d -p 8080:8080 -e SPRING_PROFILES_ACTIVE=docker -e SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER_URI=http://auth-server:9000 --link auth-server:auth-server spring-7-gateway:0.0.1-SNAPSHOT
```

- Depende de tudo
- Faz o roteamento

## Curso

### Spring Framework 7

- [NEW] [Spring Boot 4, Spring Framework 7: Beginner to Guru]()
- [Spring AI: Beginner to Guru](https://www.udemy.com/course/spring-ai-beginner-to-guru/)
- [Hibernate and Spring Data JPA: Beginner to Guru](https://www.udemy.com/course/hibernate-and-spring-data-jpa-beginner-to-guru/)
- [API First Engineering with Spring Boot](https://www.udemy.com/course/api-first-engineering-with-spring-boot)
- [Introduction to Kafka with Spring Boot](https://www.udemy.com/course/introduction-to-kafka-with-spring-boot/)
- [Spring Security Core: Beginner to Guru](https://www.udemy.com/course/spring-security-core-beginner-to-guru/)

### SQL

- [SQL Beginner to Guru: MySQL Edition - Master SQL with MySQL](https://www.udemy.com/course/sql-beginner-to-guru-mysql-edition)

### DevOps

- [Apache Maven: Beginner to Guru](https://www.udemy.com/course/apache-maven-beginner-to-guru/)
- [OpenAPI: Beginner to Guru](https://www.udemy.com/course/openapi-beginner-to-guru/)
- [OpenAPI Specification: Redocly API Documentation](https://www.udemy.com/course/openapi-specification-redocly-api-documentation/)
- [Docker for Java Developers](https://www.udemy.com/course/docker-for-java-developers/)
- [Spring Framework DevOps on AWS](https://www.udemy.com/course/spring-core-devops-on-aws)
- [Ready for Production with Spring Boot Actuator](https://www.udemy.com/course/ready-for-production-with-spring-boot-actuator)

### Web Development with Spring Framework

- [Mastering Thymeleaf with Spring Boot](https://www.udemy.com/course/mastering-thymeleaf-with-spring)

---

## Comandos

* Linux/MacOS: `ls -ltra`
* Inicializa: `docker compose up -d`
* Pausa: `docker compose stop`
* `docker compose ls -a`
* `docker ps`
* Remove: `docker compose down`

