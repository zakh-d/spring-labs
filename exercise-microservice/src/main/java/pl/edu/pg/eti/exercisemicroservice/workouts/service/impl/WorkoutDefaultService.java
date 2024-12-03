package pl.edu.pg.eti.exercisemicroservice.workouts.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.edu.pg.eti.exercisemicroservice.workouts.dto.GetWorkoutResponse;
import pl.edu.pg.eti.exercisemicroservice.workouts.entity.Workout;
import pl.edu.pg.eti.exercisemicroservice.workouts.function.ResponseToWorkoutFunction;
import pl.edu.pg.eti.exercisemicroservice.workouts.service.api.WorkoutService;

import java.util.Optional;
import java.util.UUID;

@Service
public class WorkoutDefaultService implements WorkoutService {

    RestTemplate restTemplate;
    ResponseToWorkoutFunction responseToWorkout;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Override
    public Optional<Workout> find(UUID id) {
        ResponseEntity<GetWorkoutResponse> response = restTemplate.getForEntity("/api/workouts/" + id, GetWorkoutResponse.class);
        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return Optional.empty();
        }
        return Optional.of(responseToWorkout.apply(response.getBody()));
    }
}
