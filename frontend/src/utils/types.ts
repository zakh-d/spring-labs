export interface WorkoutFormValues {
    name: string;
    duration: number;
    estimatedCalories: number;
}

export interface ExerciseFormValues {
    name: string;
    sets: number;
    reps: number;
    hasAdditionalWeight: boolean;
    additionalWeight: number;
}