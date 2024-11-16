package pl.edu.pg.eti.labproject.workouts.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.labproject.workouts.dto.PutPatchWorkoutRequest;
import pl.edu.pg.eti.labproject.workouts.entity.Workout;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToWorkoutFunction implements BiFunction<UUID, PutPatchWorkoutRequest, Workout> {

    @Override
    public Workout apply(UUID uuid, PutPatchWorkoutRequest request) {
        return Workout.builder()
                .id(uuid)
                .name(request.getName())
                .estimatedCalories(request.getEstimatedCalories())
                .duration(request.getDuration())
                .build();
    }
}
