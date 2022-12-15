import { Outlet } from 'react-router-dom';
import { CoordinatorProvider } from './CoordinatorContext';

const CoordinatorContextLayout = () => {
  return (
    <CoordinatorProvider>
      <Outlet />
    </CoordinatorProvider>
  );
};

export default CoordinatorContextLayout;