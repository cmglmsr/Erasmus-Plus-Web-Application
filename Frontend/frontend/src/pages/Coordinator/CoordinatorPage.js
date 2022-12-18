import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useContext } from "react";
import Schedule from "../../components/HomePage/Schedule";
import ProfileSummary from "../../components/common/ProfileSummary";
import ActionButtons from "../../components/common/ActionButtons";
import CoordinatorContext from "../../context/CoordinatorContext/CoordinatorContext";
import ToDoList from "../../components/HomePage/ToDoList";

function CoordinatorPage() {
  const [coordinatorData, role] = useContext(CoordinatorContext);

  console.log(coordinatorData);
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
        <Col className="mx-4">
          <div>
          <Row className="my-3">
              <ToDoList />
            </Row>
            <Row className="my-3">
              <Schedule />
            </Row>
          </div>
        </Col>
      </Row>
    </section>
  );
}
export default CoordinatorPage;
