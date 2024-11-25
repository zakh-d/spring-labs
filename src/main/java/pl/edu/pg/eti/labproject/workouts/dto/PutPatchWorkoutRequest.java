package pl.edu.pg.eti.labproject.workouts.dto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutPatchWorkoutRequest {
    private String name;
    private Integer duration;
    private Integer estimatedCalories;
}