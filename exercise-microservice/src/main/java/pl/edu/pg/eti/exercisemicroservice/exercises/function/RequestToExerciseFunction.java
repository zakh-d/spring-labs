package pl.edu.pg.eti.exercisemicroservice.exercises.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.exercisemicroservice.exercises.dto.PutPatchExerciseRequest;
import pl.edu.pg.eti.exercisemicroservice.exercises.entity.Exercise;
import pl.edu.pg.eti.exercisemicroservice.function.TriFunction;
import pl.edu.pg.eti.exercisemicroservice.workouts.entity.Workout;

import java.util.UUID;

@Component
public class RequestToExerciseFunction implements TriFunction<Workout, UUID, PutPatchExerciseRequest, Exercise> {
    @Override
    public Exercise apply(Workout workout, UUID exerciseId, PutPatchExerciseRequest request) {
        return Exercise.builder()
                .id(exerciseId)
                .name(request.getName())
                .reps(request.getReps())
                .sets(request.getSets())
                .additionalWeight(request.getAdditionalWeight())
                .workout(workout)
                .build();
    }
}
