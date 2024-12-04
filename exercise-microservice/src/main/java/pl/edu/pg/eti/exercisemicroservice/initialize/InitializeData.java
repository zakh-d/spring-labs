package pl.edu.pg.eti.exercisemicroservice.initialize;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import pl.edu.pg.eti.exercisemicroservice.exercises.entity.Exercise;
import pl.edu.pg.eti.exercisemicroservice.exercises.service.api.ExerciseService;
import pl.edu.pg.eti.exercisemicroservice.workouts.entity.Workout;
import pl.edu.pg.eti.exercisemicroservice.workouts.service.api.WorkoutService;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private ExerciseService exerciseService;
    private WorkoutService workoutService;

    public InitializeData(ExerciseService exerciseService, WorkoutService workoutService) {
        this.exerciseService = exerciseService;
        this.workoutService = workoutService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        Workout pushDay = Workout.builder()
                .id(UUID.fromString("cf0de289-27a2-4349-a681-370f1348c55f"))
                .build();

        Workout pullDay = Workout.builder()
                .id(UUID.fromString("bdf86514-c1d1-47a3-b69c-9684684ac2ec"))
                .build();

        Workout legDay = Workout.builder()
                .id(UUID.fromString("de1eaf7b-1b68-4c0a-a15e-682da5aa4c66"))
                .build();

        this.workoutService.save(pushDay);
        this.workoutService.save(pullDay);
        this.workoutService.save(legDay);

        Exercise benchPress = Exercise.builder()
                .id(UUID.fromString("38037918-36dc-4a39-ac1b-6dcec29d62be"))
                .name("Bench Press")
                .sets(5)
                .reps(8)
                .additionalWeight(70)
                .workout(pushDay)
                .build();
       Exercise chestFlies = Exercise.builder()
                .id(UUID.fromString("4dfbd783-ca2a-402c-b1fe-dff0c25f7fbd"))
                .name("Chest Flies")
                .sets(3)
                .reps(12)
                .additionalWeight(30)
                .workout(pushDay)
                .build();
       Exercise dips = Exercise.builder()
                .id(UUID.fromString("68ecc0f8-4fae-41d4-bced-f07db9fae8bd"))
                .name("Dips")
                .sets(4)
                .reps(8)
                .additionalWeight(0)
                .workout(pushDay)
                .build();

        exerciseService.save(benchPress);
        exerciseService.save(chestFlies);
        exerciseService.save(dips);

       Exercise pullUps = Exercise.builder()
                .id(UUID.fromString("e78ba76b-f337-45f0-82da-36699997fa95"))
                .name("Dips")
                .sets(5)
                .reps(10)
                .additionalWeight(0)
                .workout(pullDay)
                .build();

       Exercise barbellRow = Exercise.builder()
                .id(UUID.fromString("6f057cd2-bd08-4db2-a0a2-34a7478da473"))
                .name("Dips")
                .sets(4)
                .reps(8)
                .additionalWeight(40)
                .workout(pullDay)
                .build();

       Exercise deadlift = Exercise.builder()
                .id(UUID.fromString("0ef1ec25-b586-46e1-a9ab-52c6f6aab90b"))
                .name("Deadlift")
                .sets(5)
                .reps(6)
                .additionalWeight(100)
                .workout(pullDay)
                .build();

        exerciseService.save(pullUps);
        exerciseService.save(barbellRow);
        exerciseService.save(deadlift);

       Exercise squads = Exercise.builder()
                .id(UUID.fromString("00129945-fdb5-4027-b86b-ad1be26f6376"))
                .name("Deadlift")
                .sets(5)
                .reps(6)
                .additionalWeight(70)
                .workout(legDay)
                .build();

       Exercise legPress = Exercise.builder()
                .id(UUID.fromString("dd3a5358-4fcc-45c2-9b57-e14afdfef5e2"))
                .name("Leg Press")
                .sets(4)
                .reps(8)
                .additionalWeight(150)
                .workout(legDay)
                .build();

       Exercise legExtension = Exercise.builder()
                .id(UUID.fromString("144babd6-4869-42a8-93a0-f90e21b7bea9"))
                .name("Leg Extension")
                .sets(3)
                .reps(12)
                .additionalWeight(60)
                .workout(legDay)
                .build();

        exerciseService.save(squads);
        exerciseService.save(legPress);
        exerciseService.save(legExtension);

        System.out.println("Initialization completed");
    }
}
