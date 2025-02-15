package pl.edu.pg.eti.exercisemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExerciseMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseMicroserviceApplication.class, args);
    }

}
