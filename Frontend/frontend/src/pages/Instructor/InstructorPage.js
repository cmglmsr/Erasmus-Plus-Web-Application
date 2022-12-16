import ProfileSummary from "../../components/common/ProfileSummary";
import ActionButtons from "../../components/common/ActionButtons";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useContext } from "react";
import Schedule from "../../components/HomePage/Schedule";
import InstructorContext from "../../context/InstructorContext/InstructorContext";

function Instructor() {
  const [instructorData, role] = useContext(InstructorContext);
  console.log("instuctor ");
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
        <Row>
            <ProfileSummary
              name={instructorData.name}
              surname={instructorData.surname}
              role={role}
              term={instructorData.term}
              bilkentId={instructorData.bilkentId}
              image={instructorData.image}
              department={instructorData.department}
            />
          </Row>
          <Row className="my-4">
            <ActionButtons role={role} />
          </Row>
        </Col>
        <Col className="mx-4">
          <div>
            <Row className="my-3">
              <Schedule />
            </Row>
          </div>
        </Col>
      </Row>
    </section>
  );
}
export default Instructor;
