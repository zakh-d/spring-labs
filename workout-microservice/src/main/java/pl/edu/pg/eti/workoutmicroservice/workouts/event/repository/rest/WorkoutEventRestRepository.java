package pl.edu.pg.eti.workoutmicroservice.workouts.event.repository.rest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.edu.pg.eti.workoutmicroservice.workouts.event.repository.api.WorkoutEventRepository;

import java.net.URI;
import java.util.UUID;

@Repository
public class WorkoutEventRestRepository implements WorkoutEventRepository {
    private final RestTemplate restTemplate;

    public WorkoutEventRestRepository(
            RestTemplateBuilder builder, DiscoveryClient discoveryClient) {
        URI uri = discoveryClient.getInstances("exercises").stream().findAny().orElseThrow().getUri();
        this.restTemplate = builder.rootUri(uri.toString()).build();
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
