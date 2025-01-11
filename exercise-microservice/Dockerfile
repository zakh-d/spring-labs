FROM eclipse-temurin:17-alpine AS build

WORKDIR /app
COPY .mvn/ .mvn
COPY ./mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src/ ./src

RUN ./mvnw package

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/exercise-microservice-0.0.1-SNAPSHOT.jar /app

CMD ["java", "-jar", "exercise-microservice-0.0.1-SNAPSHOT.jar"]