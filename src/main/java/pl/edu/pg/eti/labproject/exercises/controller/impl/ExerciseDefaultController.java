package pl.edu.pg.eti.labproject.exercises.controller.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.eti.labproject.exercises.controller.api.ExerciseController;
import pl.edu.pg.eti.labproject.exercises.dto.GetExerciseListResponse;
import pl.edu.pg.eti.labproject.exercises.function.ExerciseToResponseFunction;
import pl.edu.pg.eti.labproject.exercises.function.ExercisesToResponseFunction;
import pl.edu.pg.eti.labproject.exercises.service.api.ExerciseService;
import pl.edu.pg.eti.labproject.workouts.entity.Workout;
import pl.edu.pg.eti.labproject.workouts.service.api.WorkoutService;

import java.util.UUID;

@RestController
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ExerciseDefaultController implements ExerciseController {

    private ExerciseService exerciseService;
    private WorkoutService workoutService;
    private ExerciseToResponseFunction exerciseToResponse;
    private ExercisesToResponseFunction exercisesToResponse;
    @Override
    public GetExerciseListResponse getWorkoutExercises(UUID workoutId) {
        Workout workout = workoutService.find(workoutId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return exercisesToResponse.apply(exerciseService.findByWorkout(workout));
    }

    @Override
    public void deleteExerciseFromWorkout(UUID workoutId, UUID exerciseId) {

    }

    @Override
    public void putExerciseToWorkout(UUID workoutId, UUID exerciseId) {

    }
}
