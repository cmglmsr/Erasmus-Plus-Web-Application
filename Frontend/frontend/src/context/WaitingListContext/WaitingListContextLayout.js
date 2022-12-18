import { Outlet } from 'react-router-dom';
import { WaitingListProvider } from './WaitingListContext';

const WaitingListContextLayout = () => {
  return (
    <WaitingListProvider>
      <Outlet />
    </WaitingListProvider>
  );
};

export default WaitingListContextLayout;