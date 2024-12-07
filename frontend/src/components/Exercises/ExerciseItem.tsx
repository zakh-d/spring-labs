import { ListContent, ListDescription, ListHeader, ListItem } from "semantic-ui-react";
import Exercise from "../../entities/exercise";

type PropsType = {
    exercise: Exercise
}

const ExerciseItem = ({ exercise }: PropsType) => {
    return (
        <ListItem>
            <ListContent>
                <ListHeader>{exercise.name}</ListHeader>
                <ListDescription>
                    <span>{exercise.sets}x{exercise.reps}</span>
                    {exercise.additionalWeight > 0 && <span> + {exercise.additionalWeight} kg</span>}
                </ListDescription>
            </ListContent>
        </ListItem>
    );
}

export default ExerciseItem;