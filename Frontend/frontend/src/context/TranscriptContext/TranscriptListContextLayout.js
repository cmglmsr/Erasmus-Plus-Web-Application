import { Outlet } from 'react-router-dom';
import { TranscriptListProvider } from './TranscriptListContext';

const TranscriptListContextLayout = () => {
  return (
    <TranscriptListProvider>
      <Outlet />
    </TranscriptListProvider>
  );
};

export default TranscriptListContextLayout;