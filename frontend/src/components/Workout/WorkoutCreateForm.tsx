import { Formik, FormikErrors } from "formik";
import WorkoutForm from "./WorkoutForm";
import { WorkoutFormValues } from "../../utils/types";
import { usePutWorkoutMutation } from "../../api/workout-api";
import { useNavigate } from "react-router";
import { getWorkoutListRoute } from "../../utils/routes";

type PropsType = {
    onSuccess: () => void;
}

export const WorkoutCreateForm = ({onSuccess}: PropsType) => {
    const initialValues: WorkoutFormValues = {
        name: "",
        duration: 1,
        estimatedCalories: 1
    }
    const [putWorkout, {isSuccess}] = usePutWorkoutMutation();
    const navigate = useNavigate()

    if (isSuccess) {
        navigate(getWorkoutListRoute());
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
                id: crypto.randomUUID(), ...values});
        }}
        component={WorkoutForm}
    />
}