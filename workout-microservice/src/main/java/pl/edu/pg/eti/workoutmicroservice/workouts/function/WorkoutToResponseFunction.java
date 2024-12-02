package pl.edu.pg.eti.workoutmicroservice.workouts.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.workoutmicroservice.workouts.dto.GetWorkoutResponse;
import pl.edu.pg.eti.workoutmicroservice.workouts.entity.Workout;

import java.util.function.Function;

@Component
public class WorkoutToResponseFunction implements Function<Workout, GetWorkoutResponse> {
    @Override
    public GetWorkoutResponse apply(Workout workout) {
        return GetWorkoutResponse.builder()
                .id(workout.getId())
                .name(workout.getName())
                .estimatedCalories(workout.getEstimatedCalories())
                .duration(workout.getDuration())
                .build();
    }
}
