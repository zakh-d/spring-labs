import { ReactElement } from 'react';
import { Routes, Route } from 'react-router';
import App from './App';
import { getWorkoutListRoute } from '../utils/routes';
import WorkoutListPage from '../pages/Workout/WorkoutListPage';
import LandingPage from '../pages/LandingPage';
import WorkoutDetailPage from '../pages/Workout/WorkoutDetailPage';

const AppRouting = (): ReactElement => {
    return (
        <Routes>
            <Route path="/" element={<App/>}>
                <Route index element={<LandingPage />} />
            </Route>
            <Route path={getWorkoutListRoute()} element={<App/>}>
                <Route index element={<WorkoutListPage />} />
                <Route path=":id" element={<WorkoutDetailPage />} />
            </Route>
        </Routes>
    )
}


export default AppRouting;