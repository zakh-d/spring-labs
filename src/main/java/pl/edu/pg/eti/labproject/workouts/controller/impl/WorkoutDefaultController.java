package pl.edu.pg.eti.labproject.workouts.controller.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.eti.labproject.workouts.controller.api.WorkoutController;
import pl.edu.pg.eti.labproject.workouts.dto.GetWorkoutListResponse;
import pl.edu.pg.eti.labproject.workouts.dto.GetWorkoutResponse;
import pl.edu.pg.eti.labproject.workouts.entity.Workout;
import pl.edu.pg.eti.labproject.workouts.function.WorkoutToResponseFunction;
import pl.edu.pg.eti.labproject.workouts.function.WorkoutsToResponseFunction;
import pl.edu.pg.eti.labproject.workouts.service.api.WorkoutService;

import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class WorkoutDefaultController implements WorkoutController {

    private WorkoutService workoutService;
    private WorkoutToResponseFunction workoutToResponse;
    private WorkoutsToResponseFunction workoutsToResponse;
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
}
