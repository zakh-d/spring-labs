package pl.edu.pg.eti.workoutmicroservice.workouts.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.eti.workoutmicroservice.workouts.dto.GetWorkoutListResponse;
import pl.edu.pg.eti.workoutmicroservice.workouts.dto.GetWorkoutResponse;
import pl.edu.pg.eti.workoutmicroservice.workouts.dto.PutPatchWorkoutRequest;

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

    @PutMapping("/api/workouts/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putWorkout(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutPatchWorkoutRequest request
    );

    @PatchMapping("/api/workouts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void patchWorkout(
            @PathVariable("id") UUID id,
            @RequestBody PutPatchWorkoutRequest request
    );
}
