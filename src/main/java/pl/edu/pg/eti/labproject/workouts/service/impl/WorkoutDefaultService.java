package pl.edu.pg.eti.labproject.workouts.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.labproject.workouts.entity.Workout;
import pl.edu.pg.eti.labproject.workouts.repository.api.WorkoutRepository;
import pl.edu.pg.eti.labproject.workouts.service.api.WorkoutService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Service
public class WorkoutDefaultService implements WorkoutService {
    private final WorkoutRepository workoutRepository;

    @Override
    public Optional<Workout> find(UUID id) {
        return workoutRepository.findWorkoutById(id);
    }

    @Override
    public List<Workout> findAllByName(String name) {
        return workoutRepository.findByNameContaining(name);
    }

    @Override
    public void create(Workout workout) {
       this.workoutRepository.save(workout);
    }
}
