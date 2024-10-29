package pl.edu.pg.eti.labproject.cmd_runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.edu.pg.eti.labproject.exercises.entity.Exercise;
import pl.edu.pg.eti.labproject.exercises.service.api.ExerciseService;
import pl.edu.pg.eti.labproject.workouts.entity.Workout;
import pl.edu.pg.eti.labproject.workouts.service.api.WorkoutService;

import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

@Component
public class ApplicationCommand implements CommandLineRunner {

   private final WorkoutService workoutService;
   private final ExerciseService exerciseService;

   public ApplicationCommand(WorkoutService workoutService, ExerciseService exerciseService){
       this.workoutService = workoutService;
       this.exerciseService = exerciseService;
   }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String cmd;
        main_loop:
        while (true) {
            System.out.print(">>> ");
            cmd = scanner.next();
            switch (cmd) {
                case "get_workouts" -> {
                    int index = 1;
                    for(Workout workout: workoutService.findAll()){
                        System.out.println((index++) + ": " + workout);
                    }
                }
                case "get_workout" -> {
                    UUID workoutId = UUID.fromString(scanner.next());
                    Optional<Workout> workout = workoutService.find(workoutId);
                    if (workout.isPresent()) {
                        System.out.println(workout.get());
                    } else {
                        System.out.println("NOT FOUND");
                    }
                }
                case "get_workout_exercises" -> {
                    UUID workoutId = UUID.fromString(scanner.next());
                    Optional<Workout> workout = workoutService.find(workoutId);
                    if (workout.isPresent()) {
                        int index = 1;
                        for(Exercise exercise: exerciseService.findByWorkout(workout.get())) {
                            System.out.println((index++) + ": " + exercise);
                        }
                    } else {
                        System.out.println("NOT FOUND");
                    }
                }
                case "delete_workout" -> {
                    UUID workoutId = UUID.fromString(scanner.next());
                    Optional<Workout> workout = workoutService.find(workoutId);
                    if (workout.isPresent()) {
                        workoutService.delete(workout.get());
                    } else {
                        System.out.println("NOT FOUND");
                    }
                }
                case "delete_exercise" -> {
                    UUID exerciseId = UUID.fromString(scanner.next());
                    Optional<Exercise> exercise = exerciseService.find(exerciseId);
                    if (exercise.isPresent()) {
                        exerciseService.delete(exercise.get());
                    } else {
                        System.out.println("NOT FOUND");

                    }
                }
                case "create_workout" -> {
                    scanner.skip("\n");
                    System.out.println("Workout name: ");
                    String workoutName = scanner.nextLine();
                    System.out.println("Workout duration:");
                    int workoutDuration = scanner.nextInt();
                    System.out.println("Workout estimated calories:");
                    int workoutEstimatedCalories = scanner.nextInt();

                    Workout workout = Workout.builder()
                            .id(UUID.randomUUID())
                            .name(workoutName)
                            .duration(workoutDuration)
                            .estimatedCalories(workoutEstimatedCalories)
                            .build();
                    workoutService.create(workout);
                    System.out.println(workout);
                }
                case "create_exercise" -> {
                    UUID workoutId = UUID.fromString(scanner.next());
                    Optional<Workout> workout = workoutService.find(workoutId);
                    scanner.skip("\n");
                    if (workout.isPresent()) {
                        System.out.println("Exercise name:");
                        String exerciseName = scanner.nextLine();
                        System.out.println("Exercise reps:");
                        int reps = scanner.nextInt();
                        System.out.println("Exercise sets:");
                        int sets = scanner.nextInt();
                        System.out.println("Exercise additional weight:");
                        int additionalWeight = scanner.nextInt();

                        Exercise exercise = Exercise.builder()
                                .id(UUID.randomUUID())
                                .workout(workout.get())
                                .name(exerciseName)
                                .sets(sets)
                                .reps(reps)
                                .additionalWeight(additionalWeight)
                                .build();
                        exerciseService.create(exercise);
                        System.out.println(exercise);
                    } else {
                        System.out.println("NOT FOUND");
                    }
                }
                case "quit" -> {
                    break main_loop;
                }
                default -> {
                    System.out.println(
                            "Command not found\n" +
                            "Available commands: \n" +
                            " - get_workouts \n" +
                            " - get_workout <workout_id> \n" +
                            " - get_workout_exercises <workout_id> \n" +
                            " - delete_workout <workout_id> \n" +
                            " - delete_exercise <workout_id> \n" +
                            " - create_workout \n" +
                            " - create_exercise <workout_id> \n" +
                            " - quit"
                    );
                }
            }
        }
    }
}
