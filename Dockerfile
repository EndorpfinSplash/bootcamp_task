# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy

LABEL maintainer="fast.optimus@gmail.com"

WORKDIR /app

COPY . ./

RUN ./mvnw clean install
RUN ./mvnw dependency:resolve

CMD ["./mvnw", "spring-boot:run"]