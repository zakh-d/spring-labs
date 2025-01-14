FROM eclipse-temurin:17-alpine AS build

WORKDIR /app
COPY .mvn/ .mvn
COPY ./mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src/ ./src

RUN ./mvnw package -Dmaven.test.skip

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/workout-microservice-0.0.1-SNAPSHOT.jar /app

CMD ["java", "-jar", "workout-microservice-0.0.1-SNAPSHOT.jar"]