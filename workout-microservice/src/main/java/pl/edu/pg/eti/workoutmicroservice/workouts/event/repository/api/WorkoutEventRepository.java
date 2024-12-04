package pl.edu.pg.eti.workoutmicroservice.workouts.event.repository.api;

import java.util.UUID;

public interface WorkoutEventRepository {
    void delete(UUID id);
    void create(UUID id);
}
