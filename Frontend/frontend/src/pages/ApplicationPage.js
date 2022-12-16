import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ApplicationDetails from "../components/ApplicationPage/ApplicationDetails";
import ProfileSummary from "../components/common/ProfileSummary";
import ActionButtons from "../components/common/ActionButtons";
import { useContext } from "react";
import StudentContext from "../context/StudentContext/StudentContext";
import ApplicationContext from "../context/ApplicationContext/ApplicationContext";

function ApplicationPage() {
  const [studentData, role] = useContext(StudentContext);
  const [applicationData] = useContext(ApplicationContext);

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
          <ApplicationDetails
            phoneNumber={studentData.phoneNumber}
            mail={studentData.mail}
            address={studentData.address}
            first={applicationData.pref1}
            second={applicationData.pref2}
            third={applicationData.pref3}
            fourth={applicationData.pref4}
            fifth={applicationData.pref5}
            cv=""
          />
        </Col>
      </Row>
    </section>
  );
}
export default ApplicationPage;
