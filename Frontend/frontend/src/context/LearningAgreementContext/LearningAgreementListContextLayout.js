import { Outlet } from 'react-router-dom';
import {LearningAgreementListProvider} from "./LearningAgreementListContext"

const LearningAgreementListContextLayout = () => {
  return (
    <LearningAgreementListProvider>
      <Outlet />
    </LearningAgreementListProvider>
  );
};

export default LearningAgreementListContextLayout;