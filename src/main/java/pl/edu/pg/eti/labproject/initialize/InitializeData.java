package pl.edu.pg.eti.labproject.initialize;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import pl.edu.pg.eti.labproject.exercises.entity.Exercise;
import pl.edu.pg.eti.labproject.exercises.service.api.ExerciseService;
import pl.edu.pg.eti.labproject.workouts.entity.Workout;
import pl.edu.pg.eti.labproject.workouts.service.api.WorkoutService;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private WorkoutService workoutService;
    private ExerciseService exerciseService;

    public InitializeData(WorkoutService workoutService, ExerciseService exerciseService) {
        this.workoutService = workoutService;
        this.exerciseService = exerciseService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialization Started");
        Workout pushDay = Workout.builder()
                .id(UUID.randomUUID())
                .name("Push Day")
                .duration(120)
                .estimatedCalories(900)
                .build();

        Workout pullDay = Workout.builder()
                .id(UUID.randomUUID())
                .name("Pull Day")
                .duration(90)
                .estimatedCalories(700)
                .build();

        Workout legDay = Workout.builder()
                .id(UUID.randomUUID())
                .name("Leg Day")
                .duration(100)
                .estimatedCalories(1200)
                .build();

       workoutService.create(pushDay);
       workoutService.create(pullDay);
       workoutService.create(legDay);

        Exercise benchPress = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Bench Press")
                .sets(5)
                .reps(8)
                .additionalWeight(70)
                .workout(pushDay)
                .build();
        Exercise chestFlies = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Chest Flies")
                .sets(3)
                .reps(12)
                .additionalWeight(30)
                .workout(pushDay)
                .build();
        Exercise dips = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Dips")
                .sets(4)
                .reps(8)
                .additionalWeight(0)
                .workout(pushDay)
                .build();

        exerciseService.create(benchPress);
        exerciseService.create(chestFlies);
        exerciseService.create(dips);

        Exercise pullUps = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Dips")
                .sets(5)
                .reps(10)
                .additionalWeight(0)
                .workout(pullDay)
                .build();

        Exercise barbellRow = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Dips")
                .sets(4)
                .reps(8)
                .additionalWeight(40)
                .workout(pullDay)
                .build();

        Exercise deadlift = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Deadlift")
                .sets(5)
                .reps(6)
                .additionalWeight(100)
                .workout(pullDay)
                .build();

        exerciseService.create(pullUps);
        exerciseService.create(barbellRow);
        exerciseService.create(deadlift);

        Exercise squads = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Deadlift")
                .sets(5)
                .reps(6)
                .additionalWeight(70)
                .workout(legDay)
                .build();

        Exercise legPress = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Leg Press")
                .sets(4)
                .reps(8)
                .additionalWeight(150)
                .workout(legDay)
                .build();

        Exercise legExtension = Exercise.builder()
                .id(UUID.randomUUID())
                .name("Leg Extension")
                .sets(3)
                .reps(12)
                .additionalWeight(60)
                .workout(legDay)
                .build();

        exerciseService.create(squads);
        exerciseService.create(legPress);
        exerciseService.create(legExtension);

        System.out.println("Initialization completed");
    }
}
