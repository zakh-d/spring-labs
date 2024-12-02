package pl.edu.pg.eti.exercisemicroservice.exercises.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutPatchExerciseRequest {
    private String name;
    private Integer sets;
    private Integer reps;
    private Integer additionalWeight;
}
