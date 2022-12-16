import { Outlet } from 'react-router-dom';
import { ApplicationListProvider } from './ApplicationListContext';

const ApplicationListContextLayout = () => {
  return (
    <ApplicationListProvider>
      <Outlet />
    </ApplicationListProvider>
  );
};

export default ApplicationListContextLayout;