import { createRoot } from 'react-dom/client'
import App from './components/App.tsx'
import 'semantic-ui-css/semantic.min.css'
import { ApiProvider } from '@reduxjs/toolkit/query/react';
import { workoutApi } from './api/workout-api.ts';

createRoot(document.getElementById('root')!).render(
  <ApiProvider api={workoutApi}>
      <App />
  </ApiProvider>
)
