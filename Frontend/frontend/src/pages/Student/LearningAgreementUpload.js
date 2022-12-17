import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ProfileSummary from "../../components/common/ProfileSummary";
import ActionButtons from "../../components/common/ActionButtons";
import StudentContext from "../../context/StudentContext/StudentContext";
import { useContext } from "react";
import LearningAgreementForm from "../../components/LearningAgreementPage/LearningAgreementForm";

function LearningAgreementUpload() {
  const [studentData, role] = useContext(StudentContext);

  var status;

  if (studentData.preApproval === null) {
    status = "NOT UPLOADED";
  }
  else {
    status = "UPLOADED";
  }
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <Row>
            <ProfileSummary
              name={studentData.name}
              surname={studentData.surname}
              role={role}
              term={studentData.term}
              bilkentId={studentData.bilkentId}
              image={studentData.image}
              department={studentData.department}
            />
          </Row>
          <Row className="my-4">
            <ActionButtons role={role} />
          </Row>
        </Col>
        <Col className="mx-4">
          <LearningAgreementForm status={status}/>
        </Col>
      </Row>
    </section>
  );
}
export default LearningAgreementUpload;