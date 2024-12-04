package pl.edu.pg.eti.exercisemicroservice.exercises.controller.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.eti.exercisemicroservice.exercises.controller.api.ExerciseController;
import pl.edu.pg.eti.exercisemicroservice.exercises.dto.GetExerciseListResponse;
import pl.edu.pg.eti.exercisemicroservice.exercises.dto.PutPatchExerciseRequest;
import pl.edu.pg.eti.exercisemicroservice.exercises.entity.Exercise;
import pl.edu.pg.eti.exercisemicroservice.exercises.function.ExercisesToResponseFunction;
import pl.edu.pg.eti.exercisemicroservice.exercises.function.RequestToExerciseFunction;
import pl.edu.pg.eti.exercisemicroservice.exercises.function.UpdateExerciseWithRequestFunction;
import pl.edu.pg.eti.exercisemicroservice.exercises.service.api.ExerciseService;
import pl.edu.pg.eti.exercisemicroservice.workouts.entity.Workout;
import pl.edu.pg.eti.exercisemicroservice.workouts.service.api.WorkoutService;

import java.util.UUID;

@RestController
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ExerciseDefaultController implements ExerciseController {

    private ExerciseService exerciseService;
    private WorkoutService workoutService;
    private ExercisesToResponseFunction exercisesToResponse;
    private RequestToExerciseFunction requestToExercise;
    private UpdateExerciseWithRequestFunction updateExerciseWithRequest;
    @Override
    public GetExerciseListResponse getWorkoutExercises(UUID workoutId) {
        Workout workout = workoutService.find(workoutId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return exercisesToResponse.apply(exerciseService.findByWorkout(workout));
    }

    @Override
    public void deleteExerciseFromWorkout(UUID workoutId, UUID exerciseId) {
        Exercise exercise = exerciseService.find(exerciseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Workout workout = workoutService.find(workoutId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (exercise.getWorkout().getId() != workout.getId()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        exerciseService.delete(exercise);
    }

    @Override
    public void putExerciseToWorkout(UUID workoutId, UUID exerciseId, PutPatchExerciseRequest request) {
        Workout workout = workoutService.find(workoutId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        exerciseService.save(requestToExercise.apply(workout, exerciseId, request));
    }

    @Override
    public void patchExercise(UUID workoutId, UUID exercisesId, PutPatchExerciseRequest request) {
        workoutService.find(workoutId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Exercise exercise = exerciseService.find(exercisesId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!exercise.getWorkout().getId().equals(workoutId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        exerciseService.save(updateExerciseWithRequest.apply(exercise, request));
    }
}
