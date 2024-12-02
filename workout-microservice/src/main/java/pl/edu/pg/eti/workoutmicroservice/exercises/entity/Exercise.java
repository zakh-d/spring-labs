package pl.edu.pg.eti.workoutmicroservice.exercises.entity;

import lombok.*;
import pl.edu.pg.eti.workoutmicroservice.workouts.entity.Workout;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Exercise implements Comparable<Exercise>{
    /**
     * Id of Exercise
     */
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
    private Integer additionalWeight;

    /**
     * Workout with which exercise is associated
     */
    @ToString.Exclude
    private Workout workout;

    @Override
    public int compareTo(Exercise o) {
        return getName().compareTo(o.getName());
    }
}
