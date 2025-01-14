import { ReactElement, useState } from "react";
import { useGetWorkoutsQuery } from "../../api/workout-api";
import { Button, Container, Header, Icon, List } from "semantic-ui-react";
import WorkoutPlaceholder from "../../components/Workout/WorkoutPlaceholder";
import WorkoutList from "../../components/Workout/WorkoutList";
import BasicModal from "../../components/common/BasicModal";
import { WorkoutCreateForm } from "../../components/Workout/WorkoutCreateForm";

const WorkoutListPage = (): ReactElement => {
    const { data, isError, isLoading } = useGetWorkoutsQuery();
    const [isNewWorkoutModalOpen, setNewWorkoutModalOpen] = useState(false);

    if (isLoading) {
        return (
            <Container>
                <Header>Available Workouts</Header>
                <List>
                    <WorkoutPlaceholder />
                    <WorkoutPlaceholder />
                    <WorkoutPlaceholder />
                </List>
            </Container>);
    }
    if (isError || !data) {
        return <Container>{'Data fetching Error'}</Container>;
    }


    return (
        <Container>
            <Header>Available Workouts</Header>
            <WorkoutList workouts={data.workouts} />

            <BasicModal
                isOpen={isNewWorkoutModalOpen}
                setOpen={setNewWorkoutModalOpen}
                title={"Add new workout"}
                trigger={
                    <Button fluid animated='vertical'>
                        <Button.Content visible>
                            <Icon name="plus" />
                        </Button.Content>
                        <Button.Content hidden>
                            Add new workout
                        </Button.Content>
                    </Button>
                }>
                <WorkoutCreateForm onSuccess={() => setNewWorkoutModalOpen(false)} />
            </BasicModal>


        </Container>
    )
}

export default WorkoutListPage;