package pl.edu.pg.eti.workoutmicroservice.workouts.service.api;

import pl.edu.pg.eti.workoutmicroservice.workouts.entity.Workout;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkoutService {
    Optional<Workout> find(UUID id);
    List<Workout> findAllByName(String name);
    List<Workout> findAll();
    void save(Workout workout);
    void delete(Workout workout);
}
