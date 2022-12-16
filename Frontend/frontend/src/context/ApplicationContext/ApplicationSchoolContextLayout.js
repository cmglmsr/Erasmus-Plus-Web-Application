import { Outlet } from 'react-router-dom';
import { ApplicationSchoolsProvider } from './ApplicationSchoolsContext';

const ApplicationSchoolsContextLayout = () => {
  return (
    <ApplicationSchoolsProvider>
      <Outlet />
    </ApplicationSchoolsProvider>
  );
};

export default ApplicationSchoolsContextLayout;