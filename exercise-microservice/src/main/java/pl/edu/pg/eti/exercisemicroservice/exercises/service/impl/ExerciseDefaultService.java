package pl.edu.pg.eti.exercisemicroservice.exercises.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.exercisemicroservice.exercises.entity.Exercise;
import pl.edu.pg.eti.exercisemicroservice.exercises.repository.api.ExerciseRepository;
import pl.edu.pg.eti.exercisemicroservice.exercises.service.api.ExerciseService;
import pl.edu.pg.eti.exercisemicroservice.workouts.entity.Workout;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Service
public class ExerciseDefaultService implements ExerciseService {

    ExerciseRepository exerciseRepository;
    @Override
    public Optional<Exercise> find(UUID id) {
        return exerciseRepository.findExerciseById(id);
    }

    @Override
    public List<Exercise> findByWorkout(Workout workout) {
        return exerciseRepository.findExerciseByWorkout(workout);
    }

    @Override
    public void save(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    @Override
    public void delete(Exercise exercise) {
        exerciseRepository.delete(exercise);
    }
}
