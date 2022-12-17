import ProfileSummary from "../../components/common/ProfileSummary";
import ActionButtons from "../../components/common/ActionButtons";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useContext } from "react";
import Schedule from "../../components/HomePage/Schedule";
import FbmContext from "../../context/FbmContext/FbmContext";

function Fbm() {
  const [fbmData, role] = useContext(FbmContext);
  console.log("fbm");
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
        <Row>
            <ProfileSummary
              name={fbmData.name}
              surname={fbmData.surname}
              role={role}
              term={fbmData.term}
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
              <Schedule />
            </Row>
          </div>
        </Col>
      </Row>
    </section>
  );
}
export default Fbm;