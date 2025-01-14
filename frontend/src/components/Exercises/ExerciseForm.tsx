import { FormikProps } from "formik";
import { ReactElement } from "react";
import { Button, Form, FormField, FormGroup, Input } from "semantic-ui-react"
import { ExerciseFormValues } from "../../utils/types";
import { Field as FormikField } from "formik";



const ExerciseForm = ({values, errors, touched, handleChange, handleSubmit, isSubmitting}: FormikProps<ExerciseFormValues>): ReactElement => {
    return (
        <Form onSubmit={handleSubmit} loading={isSubmitting}>
            <FormField
                error={errors.name && touched.name}>
                <label>Name</label>
                <Input
                    name="name"
                    value={values.name}
                    placeholder="Exercise name"
                    onChange={handleChange}/>
                    {errors.name && touched.name && <div style={{color: '#9f3a38'}}>{errors.name}</div>}
            </FormField>
            <FormGroup>
                <FormField
                    error={errors.sets && touched.sets}>
                    <label>Sets</label>
                    <Input
                        name="sets"
                        placeholder="5"
                        min={1}
                        type="number"
                        value={values.sets}
                        onChange={handleChange}
                    />
                    {errors.sets && touched.sets && <div style={{color: '#9f3a38'}}>{errors.sets}</div>}
                </FormField>
                <FormField
                    error={errors.reps && touched.reps}>
                    <label>Reps</label>
                    <Input
                        name="reps"
                        placeholder="10"
                        type="number"
                        min={1}
                        value={values.reps}
                        onChange={handleChange}
                    />
                    {errors.reps && touched.reps && <div style={{color: '#9f3a38'}}>{errors.reps}</div>}
                </FormField>
            </FormGroup>
            <FormField>
                <label>
                    <FormikField type="checkbox" name="hasAdditionalWeight" />
                    <span style={{marginLeft: '5px'}}>Additional weight</span>
                </label>
            </FormField>
            <FormField
                disabled={!values.hasAdditionalWeight}
                error={errors.additionalWeight && touched.additionalWeight}>
                <Input
                    name="additionalWeight"
                    placeholder="40"
                    type="number"
                    min={0}
                    value={values.hasAdditionalWeight ? values.additionalWeight : 0}
                    onChange={handleChange}
                    label={{ basic: true, content: 'kg' }}
                    labelPosition='right'
                />
                {errors.additionalWeight && touched.additionalWeight && <div style={{color: '#9f3a38'}}>{errors.additionalWeight}</div>}
            </FormField>
            <FormField>
                <Button type="submit" fluid>Submit</Button>
            </FormField>
        </Form>
    )
}

export default ExerciseForm;