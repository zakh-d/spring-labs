import { ReactElement } from "react";
import { useGetWorkoutsQuery } from "../../api/workout-api";
import { Container, Header, List } from "semantic-ui-react";
import WorkoutPlaceholder from "../../components/Workout/WorkoutPlaceholder";
import WorkoutList from "../../components/Workout/WorkoutList";

const WorkoutListPage = (): ReactElement => {
const {data, isError, isLoading} = useGetWorkoutsQuery();
    if (isLoading) {
        return (
        <Container>
            <Header>Available Workouts</Header>
            <List>
                <WorkoutPlaceholder/>
                <WorkoutPlaceholder/>
                <WorkoutPlaceholder/>
            </List>
        </Container>);
    }
    if (isError || !data) {
        return <Container>{ 'Data fetching Error'}</Container>;
    }

    return (
        <Container>
            <Header>Available Workouts</Header>
            <WorkoutList workouts={data.workouts}/>
        </Container>
    )
}

export default WorkoutListPage;