package pl.edu.pg.eti.exercisemicroservice.healthcheck.dto;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class HealthCheckStatusResponse {
    private String status;
}
