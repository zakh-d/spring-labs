import { Formik, FormikErrors } from "formik";
import WorkoutForm from "./WorkoutForm";
import { WorkoutFormValues } from "../../utils/types";
import { usePutWorkoutMutation } from "../../api/workout-api";
import Workout from "../../entities/workout";

type PropsType = {
    onSuccess: () => void;
    workout: Workout;
}

export const WorkoutUpdateForm = ({workout, onSuccess}: PropsType) => {
    const initialValues: WorkoutFormValues = {
        name: workout.name,
        duration: workout.duration,
        estimatedCalories: workout.estimatedCalories
    }
    const [putWorkout, {isSuccess}] = usePutWorkoutMutation();

    if (isSuccess) {
        onSuccess();
        return <></>;
    }

    return <Formik
        initialValues={initialValues}
        validate={values => {
            let errors: FormikErrors<WorkoutFormValues> = {};
            if (values.name.length < 3) {
                errors.name = 'Workout name should be at least 3 symbols'
            }
            if (values.duration < 1) {
                errors.duration = "Workout duration should be a positive number"
            }
            if (values.estimatedCalories < 1) {
                errors.estimatedCalories = "Estimated calorie burn should be a positive number"
            }
            return errors;
        }}
        onSubmit={values => {
            putWorkout({
                id: workout.id,...values});
        }}
        component={WorkoutForm}
    />
}