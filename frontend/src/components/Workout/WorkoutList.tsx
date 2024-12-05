import {ReactElement} from "react";
import Workout from "../../entities/workout.ts";
import WorkoutItem from "./WorkoutItem.tsx";
import {Container, Header, List} from "semantic-ui-react";


type PropsType = {
    workouts: Workout[]
};
const WorkoutList = ({workouts}: PropsType): ReactElement => {
    const workoutItems = workouts.map(w => <WorkoutItem key={w.id} workout={w}/>);
    return (
        <Container>
            <Header>Available Workouts</Header>
            <List selection>
                {workoutItems}
            </List>
        </Container>
   );
}

export default WorkoutList;