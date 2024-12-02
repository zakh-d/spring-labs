package pl.edu.pg.eti.labproject.exercises.dto;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetExerciseResponse {
    private UUID id;
    private String name;
    private Integer sets;
    private Integer reps;
    private Integer additionalWeight;
    private UUID workoutId;
}
