package pl.edu.pg.eti.workoutmicroservice.workouts.entity;

import jakarta.persistence.*;
import lombok.*;

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
public class Workout implements Comparable<Workout> {

    /**
     * ID of workout
     */
    @Id
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
    @Column(name = "estimated_calories")
    private Integer estimatedCalories;

    @Override
    public int compareTo(Workout o) {
        return getName().compareTo(o.getName());
    }
}
