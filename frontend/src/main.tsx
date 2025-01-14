import { createRoot } from 'react-dom/client'
import 'semantic-ui-css/semantic.min.css'
import { Provider } from 'react-redux';
import { store } from './store/store.ts';
import { BrowserRouter } from 'react-router';
import AppRouting from './components/AppRouting.tsx';

createRoot(document.getElementById('root')!).render(
  <Provider store={store}>
      <BrowserRouter>
        <AppRouting />
      </BrowserRouter>
  </Provider>
)
