package pl.edu.pg.eti.exercisemicroservice.exercises.dto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetExerciseListResponse {
    private List<GetExerciseResponse> exercises;
    private Integer count;
}
