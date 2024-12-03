package pl.edu.pg.eti.exercisemicroservice.workouts.service.api;

import pl.edu.pg.eti.exercisemicroservice.workouts.entity.Workout;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkoutService {
    Optional<Workout> find(UUID id);
    void save(Workout workout);
    void delete(Workout workout);
}
