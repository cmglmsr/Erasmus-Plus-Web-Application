import { Outlet } from 'react-router-dom';
import { IsoProvider } from './IsoContext';

const IsoContextLayout = () => {
  return (
    <IsoProvider>
      <Outlet />
    </IsoProvider>
  );
};

export default IsoContextLayout;