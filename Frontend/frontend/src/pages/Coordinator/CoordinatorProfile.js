import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useContext } from "react";
import ProfileSummary from "../../components/common/ProfileSummary";
import ActionButtons from "../../components/common/ActionButtons";
import CoordinatorContext from "../../context/CoordinatorContext/CoordinatorContext";
import ViewProfile from "../../components/ProfilePage/ViewProfile";

function CoordinatorProfile() {
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
              term={coordinatorData.term}
              bilkentId={coordinatorData.bilkentId}
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
              <ViewProfile
                name={coordinatorData.name}
                surname={coordinatorData.surname}
                phoneNumber={coordinatorData.phoneNumber}
                mail={coordinatorData.mail}
                dateOfBirth={coordinatorData.dateOfBirth}
                gender={coordinatorData.gender}
                cgpa={coordinatorData.cgpa}
                nationalID={coordinatorData.nationalID}
                eng101grade={coordinatorData.eng101grade}
                eng102grade={coordinatorData.eng102grade}
              />
            </Row>
          </div>
        </Col>
      </Row>
    </section>
  );
}
export default CoordinatorProfile;
