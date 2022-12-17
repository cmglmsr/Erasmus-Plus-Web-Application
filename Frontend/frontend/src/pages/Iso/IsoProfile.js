import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useContext } from "react";
import ProfileSummary from "../../components/common/ProfileSummary";
import ActionButtons from "../../components/common/ActionButtons";
import ViewProfile from "../../components/ProfilePage/ViewProfile";
import IsoContext from "../../context/IsoContext/IsoContext";

function IsoProfile() {
  const [isoData, role] = useContext(IsoContext);
    
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <Row>
          <ProfileSummary
              name={isoData.name}
              surname={isoData.surname}
              role={role}
              term=""
              bilkentId={isoData.bilkentId}
              image={isoData.image}
              department={isoData.department}
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
                name={isoData.name}
                surname={isoData.surname}
                phoneNumber={isoData.phoneNumber}
                mail={isoData.mail}
                dateOfBirth={isoData.dateOfBirth}
                gender={isoData.gender}
              />
            </Row>
          </div>
        </Col>
      </Row>
    </section>
  );
}
export default IsoProfile;