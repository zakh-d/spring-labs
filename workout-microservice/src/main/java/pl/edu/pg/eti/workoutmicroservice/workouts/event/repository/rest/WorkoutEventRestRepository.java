package pl.edu.pg.eti.workoutmicroservice.workouts.event.repository.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.edu.pg.eti.workoutmicroservice.workouts.event.repository.api.WorkoutEventRepository;

import java.util.UUID;

@Repository
public class WorkoutEventRestRepository implements WorkoutEventRepository {
    private final RestTemplate restTemplate;

    public WorkoutEventRestRepository(
            RestTemplateBuilder builder,
            @Value("${workouts.exercises-microservice.url}") String exercisesUrl) {
        this.restTemplate = builder.rootUri(exercisesUrl).build();
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/workouts/{id}", id);
    }

    @Override
    public void create(UUID id) {
        restTemplate.put("/api/workouts/{id}", null, id);
    }
}
