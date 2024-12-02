package pl.edu.pg.eti.workoutmicroservice.workouts.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetWorkoutResponse {
    private UUID id;
    private String name;
    private Integer duration;
    private Integer estimatedCalories;
}