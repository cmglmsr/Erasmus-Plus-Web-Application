import { Outlet } from 'react-router-dom';
import { ApplicationProvider } from './ApplicationContext';

const ApplicationContextLayout = () => {
  return (
    <ApplicationProvider>
      <Outlet />
    </ApplicationProvider>
  );
};

export default ApplicationContextLayout;