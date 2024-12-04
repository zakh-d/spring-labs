package pl.edu.pg.eti.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${workouts.gateway.host}") String host,
            @Value("${workouts.workouts-microservice.url}") String workoutsUrl,
            @Value("${workouts.exercises-microservice.url}") String exercisesUrl
    ) {
       return builder.routes()
               .route("workouts", route -> route.host(host)
                       .and()
                       .path(
                               "/api/workouts/{id}",
                               "/api/workouts"
                       )
                       .uri(workoutsUrl))
               .route("exercises", route -> route.host(host)
                       .and()
                       .path(
                               "/api/workouts/{id}/exercises",
                               "/api/workouts/{workout_id}/exercises/{exercise_id}"
                       )
                       .uri(exercisesUrl)).build();
    }

}
