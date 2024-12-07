import {createApi, fetchBaseQuery} from "@reduxjs/toolkit/query/react";
import Workout from "../entities/workout.ts";
import { mapKeysToCamelCase } from "../utils/to_camel_case.ts";
import Exercise from "../entities/exercise.ts";

type WorkoutApi = {
    id: string,
    name: string,
    duration: number,
    estimated_calories: number,
}

type WorkoutApiList = {
    workouts: WorkoutApi[],
    count: number
}

type WorkoutList = {
    workouts: Workout[],
    count: number
}

type ExerciseApi = {
    id: string,
    name: string,
    sets: number,
    reps: number,
    additional_weight: number,
    workout_id: string
}

type ExerciseApiList = {
    exercises: ExerciseApi[],
    count: number
}

type ExerciseList = {
    exercises: Exercise[],
    count: number
}


export const workoutApi = createApi({
    reducerPath: 'workoutApi',
    baseQuery: fetchBaseQuery({
        baseUrl: "http://localhost:7003/api"
    }),
    endpoints: builder => ({
        getWorkouts: builder.query<WorkoutList, void>({
            query: () => '/workouts',
            transformResponse: (response: WorkoutApiList) => mapKeysToCamelCase<WorkoutApiList, WorkoutList>(response)
        }),
        getWorkout: builder.query<Workout, string>({
            query: (id) => `/workouts/${id}`,
            transformResponse: (response: WorkoutApi) => mapKeysToCamelCase<WorkoutApi, Workout>(response)
        }),
        getWorkoutExercises: builder.query<ExerciseList, string>({
            query: (id) => `/workouts/${id}/exercises`,
            transformResponse: (response: ExerciseApiList) => mapKeysToCamelCase<ExerciseApiList, ExerciseList>(response)
        })
    })
});

export const {useGetWorkoutsQuery, useGetWorkoutQuery, useGetWorkoutExercisesQuery} = workoutApi;