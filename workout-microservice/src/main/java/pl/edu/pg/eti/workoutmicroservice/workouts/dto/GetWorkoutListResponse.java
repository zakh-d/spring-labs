package pl.edu.pg.eti.workoutmicroservice.workouts.dto;

import java.util.List;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetWorkoutListResponse {
    private List<GetWorkoutResponse> workouts;
    private Integer count;
}
