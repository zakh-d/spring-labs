import { ReactElement } from "react";
import Workout from "../../entities/workout";
import { Header, List, Popup } from "semantic-ui-react";
import { useGetWorkoutExercisesQuery } from "../../api/workout-api";
import ExerciseList from "../Exercises/ExerciseList";
import WorkoutPlaceholder from "./WorkoutPlaceholder";

type PropsType = {
    workout: Workout
}

const WorkoutDetail = ({workout}: PropsType): ReactElement => {
    const { data, isLoading, isError } = useGetWorkoutExercisesQuery(workout.id);

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

            <Header as="h3">Exercises</Header>
            {isLoading ? <WorkoutPlaceholder /> : <ExerciseList exercises={data.exercises} />}

        </>
    )
}

export default WorkoutDetail;