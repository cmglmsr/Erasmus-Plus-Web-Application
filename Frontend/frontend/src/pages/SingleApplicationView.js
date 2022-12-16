import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import { useContext } from "react";
import ProfileSummary from "../components/common/ProfileSummary";
import CoordinatorContext from "../context/CoordinatorContext/CoordinatorContext";

import ActionButtons from "../components/common/ActionButtons";
import ApplicationDetailsCoordinator from "../components/ApplicationPage/ApplicationDetailsCoordinator";

function SingleApplicationView() {
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
          <ApplicationDetailsCoordinator          />
        </Col>
      </Row>
    </section>
  );
}
export default SingleApplicationView;
