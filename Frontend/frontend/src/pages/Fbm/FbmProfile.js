import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useContext } from "react";
import ProfileSummary from "../../components/common/ProfileSummary";
import ActionButtons from "../../components/common/ActionButtons";
import ViewProfile from "../../components/ProfilePage/ViewProfile";
import FbmContext from "../../context/FbmContext/FbmContext";

function FbmProfile() {
  const [fbmData, role] = useContext(FbmContext);
    
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <Row>
          <ProfileSummary
              name={fbmData.name}
              surname={fbmData.surname}
              role={role}
              term=""
              bilkentId={fbmData.bilkentId}
              image={fbmData.image}
              department={fbmData.department}
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
                name={fbmData.name}
                surname={fbmData.surname}
                phoneNumber={fbmData.phoneNumber}
                mail={fbmData.mail}
                dateOfBirth={fbmData.dateOfBirth}
                gender={fbmData.gender}
              />
            </Row>
          </div>
        </Col>
      </Row>
    </section>
  );
}
export default FbmProfile;