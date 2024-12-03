package pl.edu.pg.eti.exercisemicroservice.workouts.controller.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pg.eti.exercisemicroservice.workouts.controller.api.WorkoutController;
import pl.edu.pg.eti.exercisemicroservice.workouts.entity.Workout;
import pl.edu.pg.eti.exercisemicroservice.workouts.service.api.WorkoutService;

import java.util.UUID;

@RestController
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class WorkoutDefaultController implements WorkoutController {

    private WorkoutService workoutService;
    @Override
    public void deleteWorkout(UUID id) {
        workoutService.find(id).ifPresent(workout -> workoutService.delete(workout));
    }

    @Override
    public void putWorkout(UUID id) {
        workoutService.save(Workout.builder().id(id).build());
    }

}
