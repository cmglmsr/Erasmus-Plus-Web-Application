import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useContext } from "react";
import ProfileSummary from "../../components/common/ProfileSummary";
import ActionButtons from "../../components/common/ActionButtons";
import TranscriptList from "../../components/TranscriptListPage/TranscriptList";
import IsoContext from "../../context/IsoContext/IsoContext";

function TranscriptListPage() {
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
              id={isoData.bilkentId}
              image={isoData.image}
              department={isoData.department}
            />
          </Row>
          <Row className="my-4">
            <ActionButtons role={role} />
          </Row>
        </Col>
        <Col className="mx-3">
          <TranscriptList/>
        </Col>
      </Row>
    </section>
  );
}

export default TranscriptListPage;