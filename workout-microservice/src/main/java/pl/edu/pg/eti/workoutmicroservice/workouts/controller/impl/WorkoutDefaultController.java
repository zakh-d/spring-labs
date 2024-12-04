package pl.edu.pg.eti.workoutmicroservice.workouts.controller.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.eti.workoutmicroservice.workouts.controller.api.WorkoutController;
import pl.edu.pg.eti.workoutmicroservice.workouts.dto.GetWorkoutListResponse;
import pl.edu.pg.eti.workoutmicroservice.workouts.dto.GetWorkoutResponse;
import pl.edu.pg.eti.workoutmicroservice.workouts.dto.PutPatchWorkoutRequest;
import pl.edu.pg.eti.workoutmicroservice.workouts.entity.Workout;
import pl.edu.pg.eti.workoutmicroservice.workouts.function.RequestToWorkoutFunction;
import pl.edu.pg.eti.workoutmicroservice.workouts.function.UpdateWorkoutWithRequestFunction;
import pl.edu.pg.eti.workoutmicroservice.workouts.function.WorkoutToResponseFunction;
import pl.edu.pg.eti.workoutmicroservice.workouts.function.WorkoutsToResponseFunction;
import pl.edu.pg.eti.workoutmicroservice.workouts.service.api.WorkoutService;

import java.util.UUID;

@RestController
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class WorkoutDefaultController implements WorkoutController {

    private WorkoutService workoutService;
    private WorkoutToResponseFunction workoutToResponse;
    private WorkoutsToResponseFunction workoutsToResponse;
    private RequestToWorkoutFunction requestToWorkout;
    private UpdateWorkoutWithRequestFunction updateWorkout;

    @Override
    public GetWorkoutListResponse getWorkouts() {
        return workoutsToResponse.apply(workoutService.findAll());
    }

    @Override
    public GetWorkoutResponse getWorkout(UUID id) {
        return workoutService
                .find(id)
                .map(workoutToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteWorkout(UUID id) {
        workoutService.find(id).ifPresent(workout -> workoutService.delete(workout));
    }

    @Override
    public void putWorkout(UUID id, PutPatchWorkoutRequest request) {
        workoutService.save(requestToWorkout.apply(id, request));
    }

    @Override
    public void patchWorkout(UUID id, PutPatchWorkoutRequest request) {
        Workout workout = workoutService.find(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Workout updatedWorkout = updateWorkout.apply(workout, request);
        workoutService.save(updatedWorkout);
    }
}
