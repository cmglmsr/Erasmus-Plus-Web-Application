import { Outlet } from 'react-router-dom';
import { StudentProvider } from './StudentContext';

const StudentContextLayout = () => {
  return (
    <StudentProvider>
      <Outlet />
    </StudentProvider>
  );
};

export default StudentContextLayout;