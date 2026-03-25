# Docker Commands

Use Spring Boot Maven Plugin to build a Docker image:

```shell
./mvnw clean package spring-boot:build-image

./mvnw clean package spring-boot:build-image -DskipTests=true
```

Inspect the Docker image:

```shell
docker image inspect docker.io/library/spring-7-gateway:0.0.1-SNAPSHOT
```

Run the Docker image:

```shell
docker run spring-7-gateway:0.0.1-SNAPSHOT
```

Run the Docker image with port mapping:

```shell
docker run -p 8080:8080 spring-7-gateway:0.0.1-SNAPSHOT
```

Run the Docker image in background:

```shell
docker run -d -p 8080:8080 spring-7-gateway:0.0.1-SNAPSHOT
```

List running Docker containers:

```shell
docker ps
```

Stop a running Docker container:

```shell
docker stop <container-id>
```

Name and Run the Docker image in background:

```shell
docker run --name gateway -d -p 8080:8080 spring-7-gateway:0.0.1-SNAPSHOT
```

Stop a running Docker container by name:

```shell
docker stop gateway
```

Restart a stopped Docker container by name. This will restore using the previous settings.

```shell
docker start gateway
```

# Images

* `spring-7-gateway:0.0.1-SNAPSHOT`
* `spring-7-auth-server:0.0.1-SNAPSHOT`
* `spring-7-rest-mvc:0.0.1-SNAPSHOT`
* `spring-7-reactive-mongo:0.0.1-SNAPSHOT`
* `spring-7-reactive:0.0.1-SNAPSHOT`