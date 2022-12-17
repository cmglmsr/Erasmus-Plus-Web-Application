import { Outlet } from 'react-router-dom';
import {PreApprovalListProvider} from "./PreApprovalListContext"

const PreApprovalListContextLayout = () => {
  return (
    <PreApprovalListProvider>
      <Outlet />
    </PreApprovalListProvider>
  );
};

export default PreApprovalListContextLayout;