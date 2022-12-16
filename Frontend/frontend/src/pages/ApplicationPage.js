import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ApplicationDetails from "../components/ApplicationPage/ApplicationDetails";
import ProfileSummary from "../components/common/ProfileSummary";
import ActionButtons from "../components/common/ActionButtons";
import { useContext } from "react";
import StudentContext from "../context/StudentContext/StudentContext";

function ApplicationPage() {
  const [studentData, role, application] = useContext(StudentContext);

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
            first={application.pref1}
            second={application.pref2}
            third={application.pref3}
            fourth={application.pref4}
            fifth={application.pref5}
            status={application.status}
            term={application.term}
          />
        </Col>
      </Row>
    </section>
  );
}
export default ApplicationPage;
