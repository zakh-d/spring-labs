import {createApi, fetchBaseQuery} from "@reduxjs/toolkit/query/react";
import Workout from "../entities/workout.ts";
import { mapKeysToCamelCase } from "../utils/to_camel_case.ts";

type WorkoutApi = {
    id: string,
    name: string,
    duration: number,
    estimated_calories: number,
}

type WorkoutListDto = {
    workouts: WorkoutApi[],
    count: number
}

type WorkoutList = {
    workouts: Workout[],
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
            transformResponse: (response: WorkoutListDto) => mapKeysToCamelCase<WorkoutListDto, WorkoutList>(response)
        }),
        getWorkout: builder.query<Workout, string>({
            query: (id) => `/workouts/${id}`,
            transformResponse: (response: WorkoutApi) => mapKeysToCamelCase<WorkoutApi, Workout>(response)
        })
    })
});

export const {useGetWorkoutsQuery, useGetWorkoutQuery } = workoutApi;