import { ReactElement, useState } from "react";
import Workout from "../../entities/workout";
import { Button, Dropdown, DropdownHeader, DropdownItem, DropdownMenu, Header, Icon, List, Popup } from "semantic-ui-react";
import { useDeleteWorkoutMutation, useGetWorkoutExercisesQuery } from "../../api/workout-api";
import ExerciseList from "../Exercises/ExerciseList";
import ConfirmDeleteModal from "../common/ConfirmDeleteModal";
import WorkoutPlaceholder from "./WorkoutPlaceholder";
import { getWorkoutListRoute } from "../../utils/routes";
import { useNavigate } from "react-router";
import BasicModal from "../common/BasicModal";
import ExerciseCreateForm from "../Exercises/ExerciseCreateForm";
import { WorkoutUpdateForm } from "./WorkoutUpdateForm";

type PropsType = {
    workout: Workout
}

const WorkoutDetail = ({workout}: PropsType): ReactElement => {
    const { data, isLoading, isError } = useGetWorkoutExercisesQuery(workout.id);
    const [deleteWorkout, result] = useDeleteWorkoutMutation();
    const [createExerciseModalOpen, setCreateExerciseModalOpen] = useState(false);
    const [editWorkoutModalOpen, setEditWorkoutModalOpen] = useState(false);
    const navigate = useNavigate()

    if (result.isSuccess) {
        navigate(getWorkoutListRoute());
        return <></>;
    }

    if ((isError || !data) && !isLoading) {
        return <div>Error...</div>;
    }
    return (
        <>
            <Header as="h2">{workout.name}</Header>
            <List>
                <List.Item><b>Time</b>: {workout.duration} min</List.Item>
                <List.Item>
                    <Popup
                        header="Calorie burn"
                        content="Its only an estimate, actual calorie burn may vary"
                        trigger={<span><b>Calorie burn</b>: {workout.estimatedCalories} kcal</span>}
                    />
                </List.Item>
            </List>

            <Dropdown
                icon='options'
                floating
                button
                className='icon'>
                <DropdownMenu>
                    <DropdownHeader icon='pencil alternate' content='Workout Actions'/>
                    <BasicModal
                        trigger={<DropdownItem>Edit</DropdownItem>}
                        title={`Edit ${workout.name} Workout`}
                        isOpen={editWorkoutModalOpen} setOpen={setEditWorkoutModalOpen}
                    >
                        <WorkoutUpdateForm workout={workout} onSuccess={() => {setEditWorkoutModalOpen(false)}} />
                    </BasicModal>
                    <ConfirmDeleteModal 
                        title={`Delete ${workout.name} Workout`}
                        content={`Are you sure you want to delete ${workout.name} workout? This action cannot be undone.`}
                        trigger={<DropdownItem>Delete</DropdownItem>}
                        action={() => deleteWorkout(workout.id)} />
                </DropdownMenu>
            </Dropdown>

            <Header as="h3">Exercises</Header>
            {isLoading ? <WorkoutPlaceholder /> : <ExerciseList exercises={data.exercises} />}
            <BasicModal 
                title={`Add exercise to ${workout.name}`}
                trigger={<Button fluid animated="vertical">
                    <Button.Content visible>
                        <Icon name="plus" />
                    </Button.Content>
                    <Button.Content hidden>
                        Add new exercise to {workout.name}
                    </Button.Content>
                </Button>} isOpen={createExerciseModalOpen} setOpen={setCreateExerciseModalOpen}>
                    <ExerciseCreateForm workout={workout} onSuccess={() => {setCreateExerciseModalOpen(false)}}/>
                    
            </BasicModal>

        </>
    )
}

export default WorkoutDetail;