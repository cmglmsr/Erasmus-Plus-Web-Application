import ApplicationList from "../components/ApplicationListPage/ApplicationList";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useContext } from "react";
import ProfileSummary from "../components/common/ProfileSummary";
import ActionButtons from "../components/common/ActionButtons";
import CoordinatorContext from "../context/CoordinatorContext/CoordinatorContext";




function ApplicationListPage() {
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
          <ApplicationList/>
        </Col>
      </Row>
    </section>
  );
}

export default ApplicationListPage;
