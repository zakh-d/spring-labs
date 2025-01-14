import {createApi, fetchBaseQuery} from "@reduxjs/toolkit/query/react";
import Workout from "../entities/workout.ts";
import { mapKeysToCamelCase, mapKeysToSnakeCase } from "../utils/to_camel_case.ts";
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


const API_HOST = import.meta.env.VITE_API_HOST || 'localhost:7000';

export const workoutApi = createApi({
    reducerPath: 'workoutApi',
    baseQuery: fetchBaseQuery({
        baseUrl: `http://${API_HOST}/api`
    }),
    tagTypes: ['Workout', 'Exercise'],
    endpoints: builder => ({
        getWorkouts: builder.query<WorkoutList, void>({
            query: () => '/workouts',
            transformResponse: (response: WorkoutApiList) => mapKeysToCamelCase<WorkoutApiList, WorkoutList>(response),
            providesTags: [{type: 'Workout', id: 'LIST'}],
        }),
        getWorkout: builder.query<Workout, string>({
            query: (id) => `/workouts/${id}`,
            transformResponse: (response: WorkoutApi) => mapKeysToCamelCase<WorkoutApi, Workout>(response),
            providesTags: (_result, _error, id, _meta) => [{type: 'Workout', id}],
        }),
        deleteWorkout: builder.mutation<void, string>({
            query: (id) => ({
                url: `/workouts/${id}`,
                method: 'DELETE',
            }),
            invalidatesTags: (_result, _error, id, _meta) => [{type: 'Workout', id: 'LIST'}, {type: 'Workout', id}]
        }),
        putWorkout: builder.mutation<void, Workout>({
            query: (workout) => ({
                url: `/workouts/${workout.id}`,
                method: 'PUT',
                body: mapKeysToSnakeCase<Workout, WorkoutApi>(workout)
            }),
            invalidatesTags: (_result, _error, {id}, _meta) => [{type: 'Workout', id}, {type: 'Workout', id: 'LIST'}],
        }),
        getWorkoutExercises: builder.query<ExerciseList, string>({
            query: (id) => `/workouts/${id}/exercises`,
            transformResponse: (response: ExerciseApiList) => mapKeysToCamelCase<ExerciseApiList, ExerciseList>(response),
            providesTags: (_result, _error, workoutId, _meta) => [{type: 'Exercise', id: `LIST-${workoutId}`}],
        }),
        deleteExercise: builder.mutation<void, {workoutId: string, exerciseId: string}>({
            query: ({workoutId, exerciseId}) => ({
                url: `/workouts/${workoutId}/exercises/${exerciseId}`,
                method: 'DELETE'
            }),
            invalidatesTags: (_result, _error, {workoutId}, _meta) =>  [{type: 'Exercise', id: `LIST-${workoutId}`}],
        }),
        putExercise: builder.mutation<void, {workoutId: string, exercise: Exercise}>({
            query: ({workoutId, exercise}) => ({
                url: `/workouts/${workoutId}/exercises/${exercise.id}`,
                method: 'PUT',
                body: mapKeysToSnakeCase<Exercise, ExerciseApi>(exercise)
            }),
            invalidatesTags: (_result, _error, {workoutId}, _meta) =>  [{type: 'Exercise', id: `LIST-${workoutId}`}],
        }),
    })
});

export const {
    useGetWorkoutsQuery,
    useGetWorkoutQuery,
    usePutWorkoutMutation,
    useGetWorkoutExercisesQuery,
    useDeleteWorkoutMutation,
    useDeleteExerciseMutation,
    usePutExerciseMutation
} = workoutApi;