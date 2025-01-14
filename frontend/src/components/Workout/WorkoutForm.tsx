import { FormikProps } from "formik";
import { ReactElement } from "react";
import { Button, Form, FormField, Input } from "semantic-ui-react"
import { WorkoutFormValues } from "../../utils/types";



const WorkoutForm = ({values, errors, touched, handleChange, handleSubmit, isSubmitting}: FormikProps<WorkoutFormValues>): ReactElement => {
    return (
        <Form onSubmit={handleSubmit} loading={isSubmitting}>
            <FormField
                error={errors.name && touched.name}>
                <label>Name</label>
                <Input
                    name="name"
                    value={values.name}
                    placeholder="Workout name"
                    onChange={handleChange}/>
                    {errors.name && touched.name && <div style={{color: '#9f3a38'}}>{errors.name}</div>}
            </FormField>
            <FormField
                error={errors.duration && touched.duration}>
                <label>Duration</label>
                <Input
                    name="duration"
                    icon="clock"
                    iconPosition="left"
                    placeholder="60"
                    min={1}
                    type="number"
                    value={values.duration}
                    onChange={handleChange}
                    label={{ basic: true, content: 'min' }}
                    labelPosition='right'
                />
                {errors.duration && touched.duration && <div style={{color: '#9f3a38'}}>{errors.duration}</div>}
            </FormField>
            <FormField
                error={errors.estimatedCalories && touched.estimatedCalories}>
                <label>Estimated calorie burn</label>
                <Input
                    name="estimatedCalories"
                    icon="fire"
                    iconPosition="left"
                    placeholder="900"
                    type="number"
                    min={1}
                    value={values.estimatedCalories}
                    onChange={handleChange}
                    label={{ basic: true, content: 'kcal' }}
                    labelPosition='right'
                />
                {errors.estimatedCalories && touched.estimatedCalories && <div style={{color: '#9f3a38'}}>{errors.estimatedCalories}</div>}
            </FormField>
            <FormField>
                <Button type="submit" fluid>Submit</Button>
            </FormField>
        </Form>
    )
}

export default WorkoutForm;