package pl.edu.pg.eti.workoutmicroservice.initialize;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import pl.edu.pg.eti.workoutmicroservice.workouts.entity.Workout;
import pl.edu.pg.eti.workoutmicroservice.workouts.service.api.WorkoutService;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private WorkoutService workoutService;

    public InitializeData(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialization Started");
        Workout pushDay = Workout.builder()
                .id(UUID.fromString("cf0de289-27a2-4349-a681-370f1348c55f"))
                .name("Push Day")
                .duration(120)
                .estimatedCalories(900)
                .build();

        Workout pullDay = Workout.builder()
                .id(UUID.fromString("bdf86514-c1d1-47a3-b69c-9684684ac2ec"))
                .name("Pull Day")
                .duration(90)
                .estimatedCalories(700)
                .build();

        Workout legDay = Workout.builder()
                .id(UUID.fromString("de1eaf7b-1b68-4c0a-a15e-682da5aa4c66"))
                .name("Leg Day")
                .duration(100)
                .estimatedCalories(1200)
                .build();

       workoutService.save(pushDay);
       workoutService.save(pullDay);
       workoutService.save(legDay);

    }
}
