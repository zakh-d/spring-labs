import {ReactElement} from "react";
import Workout from "../../entities/workout.ts";
import {ListContent, ListDescription, ListHeader, ListItem, Icon} from "semantic-ui-react";
import { Link } from "react-router";
import { getWorkoutDetailRoute } from "../../utils/routes.ts";

type PropsType = {
    workout: Workout
}
const WorkoutItem = ({workout}: PropsType) : ReactElement => {
    return (
        <ListItem as={Link} to={getWorkoutDetailRoute(workout.id)}>
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