import { Formik, FormikErrors } from "formik";
import { usePutExerciseMutation } from "../../api/workout-api";
import Exercise from "../../entities/exercise";
import { ExerciseFormValues } from "../../utils/types";
import ExerciseForm from "./ExerciseForm";

type PropsType = {
    onSuccess: () => void;
    exercise: Exercise
}


const ExerciseUpdateForm = ({exercise, onSuccess}: PropsType) => {
    const initialValues: ExerciseFormValues = {
        name: exercise.name,
        sets: exercise.sets,
        reps: exercise.reps,
        additionalWeight: exercise.additionalWeight,
        hasAdditionalWeight: exercise.additionalWeight > 0
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
                workoutId: exercise.workoutId,
                exercise: {
                    id: exercise.id, 
                    workoutId: exercise.workoutId, 
                    ...values,
                    additionalWeight: values.hasAdditionalWeight ? values.additionalWeight : 0
                }
            });
        }}
        component={ExerciseForm}
    />
}

export default ExerciseUpdateForm;