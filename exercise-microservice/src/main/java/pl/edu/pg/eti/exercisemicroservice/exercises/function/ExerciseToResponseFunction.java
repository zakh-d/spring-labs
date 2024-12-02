package pl.edu.pg.eti.labproject.exercises.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.labproject.exercises.dto.GetExerciseResponse;
import pl.edu.pg.eti.labproject.exercises.entity.Exercise;

import java.util.function.Function;

@Component
public class ExerciseToResponseFunction implements Function<Exercise, GetExerciseResponse> {
    @Override
    public GetExerciseResponse apply(Exercise exercise) {
        return GetExerciseResponse.builder()
                .id(exercise.getId())
                .name(exercise.getName())
                .reps(exercise.getReps())
                .sets(exercise.getSets())
                .additionalWeight(exercise.getAdditionalWeight())
                .workoutId(exercise.getWorkout().getId())
                .build();
    }
}
