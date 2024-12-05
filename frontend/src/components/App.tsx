import {ReactElement} from "react";
import AppHeader from "./AppHeader.tsx";
import WorkoutList from "./Workout/WorkoutList.tsx";
import {useSelector} from "react-redux";
import {selectWorkouts} from "../store/workoutSlice.ts";

const App = (): ReactElement => {
    const workouts = useSelector(selectWorkouts);
    return (
        <>
            <AppHeader/>
            <WorkoutList workouts={workouts}/>
        </>
    )
}

export default App
