import { Outlet } from 'react-router-dom';
import { InstructorProvider } from './InstructorContext';

const InstructorContextLayout = () => {
  return (
    <InstructorProvider>
      <Outlet />
    </InstructorProvider>
  );
};

export default InstructorContextLayout;