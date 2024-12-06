import {ReactElement} from "react";
import AppHeader from "./AppHeader.tsx";
import WorkoutList from "./Workout/WorkoutList.tsx";

const App = (): ReactElement => {
    return (
        <>
            <AppHeader/>
            <WorkoutList/>
        </>
    )
}

export default App
