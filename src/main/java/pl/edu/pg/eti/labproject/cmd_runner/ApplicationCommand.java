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
                case "quit" -> {
                    break main_loop;
                }
                default -> {
                    System.out.println(
                            "Command not found\n" +
                            "Available commands: \n" +
                            " - get_workouts \n" +
                            " - get_workout <workout_id> \n" +
                            " - get_workout_exercises <workout_id>"
                    );
                }
            }
        }
    }
}
