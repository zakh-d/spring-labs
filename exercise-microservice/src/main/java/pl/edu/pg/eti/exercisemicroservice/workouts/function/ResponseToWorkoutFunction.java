package pl.edu.pg.eti.exercisemicroservice.workouts.function;

import pl.edu.pg.eti.exercisemicroservice.workouts.dto.GetWorkoutResponse;
import pl.edu.pg.eti.exercisemicroservice.workouts.entity.Workout;

import java.util.function.Function;

public class ResponseToWorkoutFunction implements Function<GetWorkoutResponse, Workout> {
    @Override
    public Workout apply(GetWorkoutResponse getWorkoutResponse) {
        return Workout.builder()
                .id(getWorkoutResponse.getId())
                .name(getWorkoutResponse.getName())
                .duration(getWorkoutResponse.getDuration())
                .estimatedCalories(getWorkoutResponse.getEstimatedCalories())
                .build();
    }
}
