package pl.edu.pg.eti.labproject.exercises.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.labproject.exercises.entity.Exercise;
import pl.edu.pg.eti.labproject.exercises.repository.api.ExerciseRepository;
import pl.edu.pg.eti.labproject.exercises.service.api.ExerciseService;
import pl.edu.pg.eti.labproject.workouts.entity.Workout;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Service
public class DefaultExerciseService implements ExerciseService {

    ExerciseRepository exerciseRepository;
    @Override
    public Optional<Exercise> find(UUID id) {
        return exerciseRepository.findExerciseById(id);
    }

    @Override
    public List<Exercise> findByWorkout(Workout workout) {
        return exerciseRepository.findExerciseByWorkout(workout);
    }
}
