import { Outlet } from 'react-router-dom';
import { PlacementListProvider } from './PlacementListContext';

const PlacementListContextLayout = () => {
  return (
    <PlacementListProvider>
      <Outlet />
    </PlacementListProvider>
  );
};

export default PlacementListContextLayout;