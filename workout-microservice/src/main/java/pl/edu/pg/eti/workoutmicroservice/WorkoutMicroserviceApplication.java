package pl.edu.pg.eti.workoutmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WorkoutMicroserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkoutMicroserviceApplication.class, args);
    }

}
