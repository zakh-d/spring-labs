package pl.edu.pg.eti.workoutmicroservice.workouts.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.workoutmicroservice.workouts.dto.PutPatchWorkoutRequest;
import pl.edu.pg.eti.workoutmicroservice.workouts.entity.Workout;

import java.util.Optional;
import java.util.function.BiFunction;

@Component
public class UpdateWorkoutWithRequestFunction implements BiFunction<Workout, PutPatchWorkoutRequest, Workout> {
    @Override
    public Workout apply(Workout workout, PutPatchWorkoutRequest request) {
        return Workout.builder()
                .id(workout.getId())
                .name(Optional.ofNullable(request.getName()).orElse(workout.getName()))
                .duration(Optional.ofNullable(request.getDuration()).orElse(workout.getDuration()))
                .estimatedCalories(Optional.ofNullable(request.getEstimatedCalories()).orElse(workout.getEstimatedCalories()))
                .build();
    }
}