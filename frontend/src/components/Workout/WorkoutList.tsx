import {ReactElement} from "react";
import Workout from "../../entities/workout.ts";
import WorkoutItem from "./WorkoutItem.tsx";
import {List} from "semantic-ui-react";

type PropsType = {
    workouts: Workout[]
}

const WorkoutList = ({workouts}: PropsType): ReactElement => {
    
    const workoutItems = workouts.map((w: Workout) => <WorkoutItem key={w.id} workout={w}/>);

    return (
            <List selection>
                {workoutItems}
            </List>
   );
}

export default WorkoutList;