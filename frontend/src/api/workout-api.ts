import {createApi, fetchBaseQuery} from "@reduxjs/toolkit/query/react";
import Workout from "../entities/workout.ts";


export const workoutApi = createApi({
    reducerPath: 'workoutApi',
    baseQuery: fetchBaseQuery({
        baseUrl: "http://localhost:7003/api"
    }),
    endpoints: builder => ({
        getWorkouts: builder.query<{workouts: Workout[], count: number}, void>({
            query: () => '/workouts'
        })
    })
});

export const {useGetWorkoutsQuery } = workoutApi;