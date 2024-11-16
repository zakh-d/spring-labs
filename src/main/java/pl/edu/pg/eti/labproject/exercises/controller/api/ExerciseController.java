package pl.edu.pg.eti.labproject.exercises.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.eti.labproject.exercises.dto.GetExerciseListResponse;

import java.util.UUID;

public interface ExerciseController {
    @GetMapping("/api/workouts/{workoutId}/exercises")
    GetExerciseListResponse getWorkoutExercises(
            @PathVariable("workoutId")UUID workoutId
    );

    @DeleteMapping("/api/workouts/{workoutId}/exercises/{exerciseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteExerciseFromWorkout(
            @PathVariable("workoutId")
            UUID workoutId,
            @PathVariable("exerciseId")
            UUID exerciseId
    );

    @PutMapping("/api/workout/{workoutId}/exercises/{exerciseId}")
    void putExerciseToWorkout(
            @PathVariable("workoutId")
            UUID workoutId,
            @PathVariable("exerciseId")
            UUID exerciseId
    );
}
