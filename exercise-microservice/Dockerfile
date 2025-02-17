FROM eclipse-temurin:17-alpine AS build

WORKDIR /app
COPY .mvn/ .mvn
COPY ./mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src/ ./src

RUN ./mvnw package -Dmaven.test.skip

FROM eclipse-temurin:17-jre-alpine

RUN apk add --update curl && rm -rf /var/cache/apk/*
WORKDIR /app
COPY --from=build /app/target/exercise-microservice-0.0.1-SNAPSHOT.jar /app

CMD ["java", "-jar", "exercise-microservice-0.0.1-SNAPSHOT.jar"]