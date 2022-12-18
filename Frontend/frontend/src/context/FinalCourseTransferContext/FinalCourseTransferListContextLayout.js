import { Outlet } from 'react-router-dom';
import { FinalCourseTransferListProvider } from './FinalCourseTransferListContext';

const FinalCourseTransferListContextLayout = () => {
  return (
    <FinalCourseTransferListProvider>
      <Outlet />
    </FinalCourseTransferListProvider>
  );
};

export default FinalCourseTransferListContextLayout;