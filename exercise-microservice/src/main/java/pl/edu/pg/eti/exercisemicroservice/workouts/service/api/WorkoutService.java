package pl.edu.pg.eti.exercisemicroservice.workouts.service.api;

import pl.edu.pg.eti.exercisemicroservice.workouts.entity.Workout;

import java.util.Optional;
import java.util.UUID;

public interface WorkoutService {

    Optional<Workout> find(UUID id);
    
}
