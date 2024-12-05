import {ReactElement} from "react";
import Workout from "../../entities/workout.ts";
import {ListContent, ListDescription, ListHeader, ListItem, Icon} from "semantic-ui-react";

type PropsType = {
    workout: Workout
}
const WorkoutItem = ({workout}: PropsType) : ReactElement => {
    return (
        <ListItem>
            <ListContent>
                <ListHeader style={{marginBottom: '1em'}}>{workout.name}</ListHeader>
                <ListDescription style={{marginBottom: '1.5em'}}>
                    <span><Icon name={'clock'}/>{workout.duration} min </span>
                    <span><Icon name={'fire'}/>{workout.estimatedCalories} kcal</span>
                </ListDescription>
            </ListContent>
        </ListItem>
    );
}

export default WorkoutItem;