package pl.edu.pg.eti.exercisemicroservice.workouts.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface WorkoutController {
    @DeleteMapping("/api/workouts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteWorkout(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/workouts/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putWorkout(
            @PathVariable("id")
            UUID id
    );

}
