FROM eclipse-temurin:25-jre-jammy
LABEL authors="Juliane Maran"

ENV JAVA_OPTS=" -Xms512m -Xmx512m -Djava.security.egd=file:/dev/./urandom"

WORKDIR application

COPY ../../../target/kbe-rest-brewery-0.0.1-SNAPSHOT.jar ./

ENTRYPOINT ["java", "-jar", "kbe-rest-brewery-0.0.1-SNAPSHOT.jar"]