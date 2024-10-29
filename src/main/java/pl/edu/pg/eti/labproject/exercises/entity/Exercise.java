package pl.edu.pg.eti.labproject.exercises.entity;

import jakarta.persistence.*;
import lombok.*;
import pl.edu.pg.eti.labproject.workouts.entity.Workout;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "exercises")
public class Exercise implements Comparable<Exercise>{
    /**
     * Id of Exercise
     */
    @Id
    private UUID id;

    /**
     * Exercise name
     */
    private String name;

    /**
     * Number representing how many sets of exercise should be done
     */
    private Integer sets;

    /**
     * Number representing how many reps in each set of exercise should be done
     */
    private Integer reps;

    /**
     * If exercise requires additional weight like (dumbbells or barbells) it weight in kg can be stored here
     */
    @Column(name = "additional_weight")
    private Integer additionalWeight;

    /**
     * Workout with which exercise is associated
     */
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "workout")
    private Workout workout;

    @Override
    public int compareTo(Exercise o) {
        return getName().compareTo(o.getName());
    }
}
