package pl.edu.pg.eti.labproject.exercises.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.labproject.exercises.dto.PutPatchExerciseRequest;
import pl.edu.pg.eti.labproject.exercises.entity.Exercise;

import java.util.Optional;
import java.util.function.BiFunction;

@Component
public class UpdateExerciseWithRequestFunction implements BiFunction<Exercise, PutPatchExerciseRequest, Exercise> {
    @Override
    public Exercise apply(Exercise exercise, PutPatchExerciseRequest request) {
        return Exercise.builder()
                .id(exercise.getId())
                .name(Optional.ofNullable(request.getName()).orElse(exercise.getName()))
                .reps(Optional.ofNullable(request.getReps()).orElse(exercise.getReps()))
                .sets(Optional.ofNullable(request.getReps()).orElse(exercise.getReps()))
                .additionalWeight(Optional.ofNullable(request.getAdditionalWeight())
                        .orElse(exercise.getAdditionalWeight()))
                .workout(exercise.getWorkout())
                .build();
    }
}
