import { Link, useParams } from "react-router";
import { useGetWorkoutQuery } from "../../api/workout-api";
import { ReactElement } from "react";
import { Button, Container, Icon } from "semantic-ui-react";
import WorkoutDetail from "../../components/Workout/WorkoutDetail";
import { getWorkoutListRoute } from "../../utils/routes";
import WorkoutPlaceholder from "../../components/Workout/WorkoutPlaceholder";

const WorkoutDetailPage = (): ReactElement => {
    const { id } = useParams<{ id: string }>();
    if (!id) {
        return <div>Invalid workout id</div>;
    }
    const {data, isLoading, isError} = useGetWorkoutQuery(id);

    if (isLoading) {
        return <Container><WorkoutPlaceholder/></Container>;
    }

    if (isError || !data) {
        return <div>Error...</div>;
    }

    return (
        <Container>
            <Button animated as={Link} to={getWorkoutListRoute()}>
                <Button.Content visible style={{minWidth: "75px"}}>
                    <Icon name="arrow left" />
                </Button.Content>
                <Button.Content hidden>
                    Back to List
                </Button.Content>
            </Button>
            <WorkoutDetail workout={data} />
        </Container>
    )

}

export default WorkoutDetailPage;