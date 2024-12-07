export const WORKOUT_LIST_ROUTE = "/workouts";

export const getWorkoutListRoute = () => WORKOUT_LIST_ROUTE;
export const getWorkoutDetailRoute = (workoutId: string) => `${WORKOUT_LIST_ROUTE}/${workoutId}`;