import { ReactElement } from 'react';
import { Routes, Route } from 'react-router';
import WorkoutList from './Workout/WorkoutList';
import App from './App';
import { getWorkoutListRoute } from '../utils/routes';

const AppRouting = (): ReactElement => {
    return (
        <Routes>
            <Route path="/" element={<App/>} />
            <Route path={getWorkoutListRoute()} element={<App/>}>
                <Route index element={<WorkoutList />} />
            </Route>
        </Routes>
    )
}


export default AppRouting;