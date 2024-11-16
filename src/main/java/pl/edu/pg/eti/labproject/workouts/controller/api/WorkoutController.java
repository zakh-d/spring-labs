package pl.edu.pg.eti.labproject.workouts.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.edu.pg.eti.labproject.workouts.dto.GetWorkoutListResponse;
import pl.edu.pg.eti.labproject.workouts.dto.GetWorkoutResponse;

import java.util.UUID;

public interface WorkoutController {
    @GetMapping("/api/workouts")
    @ResponseStatus(HttpStatus.OK)
    GetWorkoutListResponse getWorkouts();

    @GetMapping("/api/workouts/{id}")
    @ResponseStatus(HttpStatus.OK)
    GetWorkoutResponse getWorkout(
            @PathVariable("id")
            UUID id
    );

    @DeleteMapping("/api/workouts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteWorkout(
            @PathVariable("id")
            UUID id
    );
}
