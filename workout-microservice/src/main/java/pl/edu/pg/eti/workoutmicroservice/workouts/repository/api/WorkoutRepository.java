package pl.edu.pg.eti.labproject.workouts.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.eti.labproject.workouts.entity.Workout;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, UUID> {
    Optional<Workout> findWorkoutById(UUID id);
    List<Workout> findByNameContaining(String name);
}