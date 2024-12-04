package pl.edu.pg.eti.exercisemicroservice.exercises.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.eti.exercisemicroservice.exercises.entity.Exercise;
import pl.edu.pg.eti.exercisemicroservice.workouts.entity.Workout;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {

    Optional<Exercise> findExerciseById(UUID id);
    List<Exercise> findExerciseByWorkout(Workout workout);
}
