# =========================
# STAGE 1 - BUILD
# =========================
FROM eclipse-temurin:25-jre-jammy AS builder

WORKDIR /application

ADD target/kbe-rest-brewery-0.0.1-snapshot.jar ./
RUN java -Djarmode=layertools -jar kbe-rest-brewery-0.0.1-snapshot.jar extract

# =========================
# STAGE 2 - RUNTIME
# =========================
FROM eclipse-temurin:25-jre-jammy

WORKDIR /application
COPY --from=builder /application/dependencies/ ./
COPY --from=builder /application/spring-boot-loader/ ./
COPY --from=builder /application/snapshot-dependencies/ ./
COPY --from=builder /application/application/ ./

# JVM otimizada para container
ENTRYPOINT ["java", \
"-XX:+UseContainerSupport", \
"-XX:MaxRAMPercentage=75.0", \
"-Djava.security.egd=file:/dev/./urandom", \
"org.springframework.boot.loader.launch.JarLauncher"]