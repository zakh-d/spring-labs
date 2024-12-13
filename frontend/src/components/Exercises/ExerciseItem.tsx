import { Divider, Dropdown, DropdownHeader, DropdownItem, DropdownMenu, ListContent, ListDescription, ListHeader, ListItem } from "semantic-ui-react";
import Exercise from "../../entities/exercise";
import ConfirmDeleteModal from "../ConfirmDeleteModal";
import { useDeleteExerciseMutation } from "../../api/workout-api";

type PropsType = {
    exercise: Exercise
}

const ExerciseItem = ({ exercise }: PropsType) => {
    const [deleteExercise, result] = useDeleteExerciseMutation();
    if (result.isSuccess) {
        return <></>
    }
    return (
        <ListItem>
            <ListContent>
                <ListHeader style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                    {exercise.name}
                    <Dropdown
                        icon='options'
                        floating
                        direction='left'
                        button
                        className='icon'>
                        <DropdownMenu>
                            <DropdownHeader icon='pencil alternate' content='Exercise Actions'/>
                            <DropdownItem>Edit</DropdownItem>
                            <ConfirmDeleteModal 
                                title={`Delete ${exercise.name} exercise`}
                                content={`Are you sure you want to delete ${exercise.name} exercise? This action cannot be undone.`}
                                trigger={<DropdownItem>Delete</DropdownItem>}
                                action={() => {
                                    deleteExercise({
                                        workoutId: exercise.workoutId,
                                        exerciseId: exercise.id
                                    });
                                }} />
                        </DropdownMenu>
                    </Dropdown>
                </ListHeader>
                <ListDescription>
                    <span>{exercise.sets}x{exercise.reps}</span>
                    {exercise.additionalWeight > 0 && <span> {exercise.additionalWeight} kg</span>}
                </ListDescription>
            </ListContent>
            <Divider/>
        </ListItem>
    );
}

export default ExerciseItem;