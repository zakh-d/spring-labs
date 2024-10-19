package pl.edu.pg.eti.labproject.exercises.service.api;

import pl.edu.pg.eti.labproject.exercises.entity.Exercise;
import pl.edu.pg.eti.labproject.workouts.entity.Workout;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseService {
    Optional<Exercise> find(UUID id);
    List<Exercise> findByWorkout(Workout workout);
}
