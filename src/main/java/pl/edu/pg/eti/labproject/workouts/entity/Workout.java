package pl.edu.pg.eti.labproject.workouts.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@ToString
@Setter
@Getter
@EqualsAndHashCode
public class Workout implements Comparable<Workout> {

    /**
     * ID of workout
     */
    private UUID id;

    /**
     * Workout name
     */
    private String name;

    /**
     * Workout duration in minutes
     */
    private Integer duration;

    /**
     * Number representing estimation of how many calories workout helps to burn
     */
    private Integer estimatedCalories;

    /**
     * List of exercises in workout
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    private List<Exercise> exercises = new ArrayList<>();

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }


    @Override
    public int compareTo(Workout o) {
        return getName().compareTo(o.getName());
    }
}
