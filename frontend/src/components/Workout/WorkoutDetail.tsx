import { ReactElement } from "react";
import Workout from "../../entities/workout";
import { Header, List, Popup } from "semantic-ui-react";

type PropsType = {
    workout: Workout
}

const WorkoutDetail = ({workout}: PropsType): ReactElement => {
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
        </>
    )
}

export default WorkoutDetail;