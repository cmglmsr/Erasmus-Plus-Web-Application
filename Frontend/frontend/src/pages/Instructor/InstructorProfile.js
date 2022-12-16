import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useContext } from "react";
import ProfileSummary from "../../components/common/ProfileSummary";
import ActionButtons from "../../components/common/ActionButtons";
import ViewProfile from "../../components/ProfilePage/ViewProfile";
import InstructorContext from "../../context/InstructorContext/InstructorContext";

function InstructoProfile() {
  const [instructorData, role] = useContext(InstructorContext);
    
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <Row>
          <ProfileSummary
              name={instructorData.name}
              surname={instructorData.surname}
              role={role}
              term=""
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
              <ViewProfile
                name={instructorData.name}
                surname={instructorData.surname}
                phoneNumber={instructorData.phoneNumber}
                mail={instructorData.mail}
                dateOfBirth={instructorData.dateOfBirth}
                gender={instructorData.gender}
                cgpa={instructorData.cgpa}
                nationalID={instructorData.nationalID}
                eng101grade={instructorData.eng101grade}
                eng102grade={instructorData.eng102grade}
              />
            </Row>
          </div>
        </Col>
      </Row>
    </section>
  );
}
export default InstructoProfile;
