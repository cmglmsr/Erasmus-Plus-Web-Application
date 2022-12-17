import { Outlet } from 'react-router-dom';
import { FbmProvider } from './FbmContext';

const FbmContextLayout = () => {
  return (
    <FbmProvider>
      <Outlet />
    </FbmProvider>
  );
};

export default FbmContextLayout;