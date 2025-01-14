package pl.edu.pg.eti.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

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
        System.out.println("host: " + host);
        System.out.println("workoutsUrl: " + workoutsUrl);
        System.out.println("exercisesUrl: " + exercisesUrl);
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
    
    @Bean
    public CorsWebFilter corsWebFilter() {

        final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
        corsConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }


}
