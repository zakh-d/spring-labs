import { Formik, FormikErrors } from "formik";
import { ExerciseFormValues } from "../../utils/types";
import { usePutExerciseMutation } from "../../api/workout-api";
import ExerciseForm from "./ExerciseForm";
import Workout from "../../entities/workout";

type PropsType = {
    onSuccess: () => void;
    workout: Workout
}

export const ExerciseCreateForm = ({onSuccess, workout}: PropsType) => {
    const initialValues: ExerciseFormValues = {
        name: "",
        sets: 1,
        reps: 1,
        additionalWeight: 0,
        hasAdditionalWeight: true
    }
    const [putExercise, {isSuccess}] = usePutExerciseMutation();

    if (isSuccess) {
        onSuccess();
        return <></>;
    }

    return <Formik
        initialValues={initialValues}
        validate={values => {
            let errors: FormikErrors<ExerciseFormValues> = {};
            if (values.name.length < 3) {
                errors.name = 'Workout name should be at least 3 symbols'
            }
            if (values.reps < 1) {
                errors.reps = "Workout duration should be a positive number"
            }
            if (values.sets < 1) {
                errors.sets = "Estimated calorie burn should be a positive number"
            }
            if (values.additionalWeight < 0) {
                errors.additionalWeight = "Estimated calorie burn should be a positive number or zero"
            }
            return errors;
        }}
        onSubmit={values => {
            putExercise({
                workoutId: workout.id,
                exercise: {
                    id: crypto.randomUUID(), 
                    workoutId: workout.id, 
                    ...values,
                    additionalWeight: values.hasAdditionalWeight ? values.additionalWeight : 0
                }
            });
        }}
        component={ExerciseForm}
    />
}

export default ExerciseCreateForm;