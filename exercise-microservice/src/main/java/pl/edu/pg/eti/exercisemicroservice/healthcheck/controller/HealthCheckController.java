package pl.edu.pg.eti.exercisemicroservice.healthcheck.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pg.eti.exercisemicroservice.healthcheck.dto.HealthCheckStatusResponse;

@RestController
public class HealthCheckController {

    @GetMapping("/api/healthcheck/exercises")
    public HealthCheckStatusResponse healthCheck() {
        return HealthCheckStatusResponse.builder().status("Everything works").build();
    }
}
