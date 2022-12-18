import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ProfileSummary from "../../components/common/ProfileSummary";
import ActionButtons from "../../components/common/ActionButtons";
import IsoContext from "../../context/IsoContext/IsoContext";
import { useContext } from "react";
import TranscriptForm from "../../components/TrandscriptSinglePage/TranscriptForm";

function TranscriptSinglePage() {
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
          <TranscriptForm />
        </Col>
      </Row>
    </section>
  );
}
export default TranscriptSinglePage;
