import {ReactElement} from "react";
import Workout from "../../entities/workout.ts";
import WorkoutItem from "./WorkoutItem.tsx";
import {Container, Header, List} from "semantic-ui-react";
import {useGetWorkoutsQuery} from "../../api/workout-api.ts";

const WorkoutList = (): ReactElement => {
    const {data, isError, isLoading} = useGetWorkoutsQuery();
    if (isLoading) {
        return (
        <Container>
            <Header>Available Workouts</Header>
            Loading...
        </Container>);
    }
    if (isError || !data) {
        return <Container>{ 'Data fetching Error'}</Container>;
    }
    const workoutItems = data.workouts.map((w: Workout) => <WorkoutItem key={w.id} workout={w}/>);

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