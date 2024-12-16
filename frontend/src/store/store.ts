import {configureStore} from "@reduxjs/toolkit";
import {workoutApi} from "../api/workout-api.ts";

export const store = configureStore({
    reducer: {
        [workoutApi.reducerPath]: workoutApi.reducer
    },
    middleware: (getDefaultMiddleware) => (
        getDefaultMiddleware().concat(workoutApi.middleware)
    )
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;