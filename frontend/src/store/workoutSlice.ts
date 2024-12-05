import {createSlice, PayloadAction, Slice} from "@reduxjs/toolkit";
import Workout from "../entities/workout.ts";
import {RootState} from "./store.ts";

type WorkoutSliceState = {
    workouts: Workout[],
    loading: boolean,
    selectedWorkoutIndex?: number
}

const initialState: WorkoutSliceState = {
    workouts: [
        {
            id: "id-1",
            name: "Push workout",
            duration: 90,
            estimatedCalories: 945,
        },
        {
            id: "id-2",
            name: "Pull workout",
            duration: 100,
            estimatedCalories: 1035,
        }
    ],
    loading: false,
    selectedWorkoutIndex: undefined
}

export const workoutSlice = createSlice({
    name: 'workout',
    initialState,
    reducers: {
        setWorkouts: (state: WorkoutSliceState, action: PayloadAction<Workout[]>) => {
            state.workouts = action.payload;
        }
    }
});


export const {setWorkouts} = workoutSlice.actions;

export const selectWorkouts = (state: RootState) => state.workout.workouts;