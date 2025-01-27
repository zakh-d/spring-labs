package pl.edu.pg.eti.exercisemicroservice.exercises.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.exercisemicroservice.exercises.dto.GetExerciseListResponse;
import pl.edu.pg.eti.exercisemicroservice.exercises.entity.Exercise;

import java.util.List;
import java.util.function.Function;

@Component
public class ExercisesToResponseFunction implements Function<List<Exercise>, GetExerciseListResponse> {
    @Override
    public GetExerciseListResponse apply(List<Exercise> exercises) {
        return GetExerciseListResponse.builder()
                .count(exercises.size())
                .exercises(
                        exercises.stream().map(new ExerciseToResponseFunction()).toList()
                )
                .build();
    }
}
