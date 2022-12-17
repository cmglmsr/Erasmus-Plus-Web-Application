import ProfileSummary from "../../components/common/ProfileSummary";
import ActionButtons from "../../components/common/ActionButtons";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useContext } from "react";
import Schedule from "../../components/HomePage/Schedule";
import IsoContext from "../../context/IsoContext/IsoContext";

function Iso() {
  const [isoData, role] = useContext(IsoContext);
  console.log("iso");
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
        <Row>
            <ProfileSummary
              name={isoData.name}
              surname={isoData.surname}
              role={role}
              term={isoData.term}
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
              <Schedule />
            </Row>
          </div>
        </Col>
      </Row>
    </section>
  );
}
export default Iso;