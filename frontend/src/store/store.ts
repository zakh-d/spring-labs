import {configureStore} from "@reduxjs/toolkit";
import {workoutSlice} from "./workoutSlice.ts";
import {workoutApi} from "../api/workout-api.ts";

export const store = configureStore({
    reducer: {
        workout: workoutSlice.reducer,
        [workoutApi.reducerPath]: workoutApi.reducer
    },
    middleware: (getDefaultMiddleware) => (
        getDefaultMiddleware().concat(workoutApi.middleware)
    )
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;