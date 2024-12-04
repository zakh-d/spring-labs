package pl.edu.pg.eti.exercisemicroservice.exercises.service.api;

import pl.edu.pg.eti.exercisemicroservice.exercises.entity.Exercise;
import pl.edu.pg.eti.exercisemicroservice.workouts.entity.Workout;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseService {
    Optional<Exercise> find(UUID id);
    List<Exercise> findByWorkout(Workout workout);
    void save(Exercise exercise);
    void delete(Exercise exercise);
}
