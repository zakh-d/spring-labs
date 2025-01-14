import { ReactElement } from "react"
import Exercise from "../../entities/exercise"
import { List } from "semantic-ui-react"
import ExerciseItem from "./ExerciseItem"

type PropsType = {
    exercises: Exercise[]
}

const ExerciseList = ({exercises}: PropsType): ReactElement => {
    return (
        <List>
            {exercises.map((exercise) => (
                <ExerciseItem key={exercise.id} exercise={exercise}/>
            ))}
        </List>
    )
}

export default ExerciseList;