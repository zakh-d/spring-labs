package pl.edu.pg.eti.exercisemicroservice.workouts.entity;

import jakarta.persistence.*;
import lombok.*;
import pl.edu.pg.eti.exercisemicroservice.exercises.entity.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "workouts")
public class Workout {

    /**
     * ID of workout
     */
    @Id
    private UUID id;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Exercise> exercises = new ArrayList<>();

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }
}
