import {createSlice, PayloadAction, Slice} from "@reduxjs/toolkit";
import Workout from "../entities/workout.ts";

type WorkoutSliceState = {
    workouts: Workout[],
    loading: boolean,
    selectedWorkoutIndex?: number
}

const initialState: WorkoutSliceState = {
    workouts: [],
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