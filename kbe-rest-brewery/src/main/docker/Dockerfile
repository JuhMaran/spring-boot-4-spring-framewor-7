FROM eclipse-temurin:25-jre-jammy AS builder

WORKDIR /application
# Replace this ADD instruction with a COPY instruction.
ADD target/kbe-rest-brewery-0.0.1-SNAPSHOT.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM eclipse-temurin:25-jre-jammy

WORKDIR /application
COPY --from=builder /application/dependencies/ ./
COPY --from=builder /application/spring-boot-loader/ ./
COPY --from=builder /application/snapshot-dependencies/ ./
COPY --from=builder /application/application/ ./

ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]