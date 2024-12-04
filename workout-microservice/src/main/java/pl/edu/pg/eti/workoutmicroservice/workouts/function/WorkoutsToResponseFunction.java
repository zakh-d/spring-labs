package pl.edu.pg.eti.workoutmicroservice.workouts.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.workoutmicroservice.workouts.dto.GetWorkoutListResponse;
import pl.edu.pg.eti.workoutmicroservice.workouts.entity.Workout;

import java.util.List;
import java.util.function.Function;

@Component
public class WorkoutsToResponseFunction implements Function<List<Workout>, GetWorkoutListResponse> {
    @Override
    public GetWorkoutListResponse apply(List<Workout> workouts) {
        return GetWorkoutListResponse
                .builder()
                .count(workouts.size())
                .workouts(workouts.stream().map(new WorkoutToResponseFunction()).toList())
                .build();
    }
}
