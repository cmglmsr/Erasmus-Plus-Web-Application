import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useContext } from "react";
import ProfileSummary from "../../src/components/common/ProfileSummary.js";
import ActionButtons from "../../src/components/common/ActionButtons";
import CoordinatorContext from "../../src/context/CoordinatorContext/CoordinatorContext";
import FinalCourseTransfer from "../components/FinalCourseTransfer/FinalCourseTransfer.js";

function FinalCourseTransferListPage(){
  const [coordinatorData, role] = useContext(CoordinatorContext);
  return (
    <section>
      <Row>
      <Col xs={3} className="mx-3">
          <Row>
            <ProfileSummary
              name={coordinatorData.name}
              surname={coordinatorData.surname}
              role={role}
              term=""
              id={coordinatorData.bilkentId}
              image={coordinatorData.image}
              department={coordinatorData.department}
            />
          </Row>
          <Row className="my-4">
            <ActionButtons role={role} />
          </Row>
        </Col>
        <Col className="mx-3">
          <FinalCourseTransfer />
        </Col>
      </Row>
    </section>
  );
}

export default FinalCourseTransferListPage;