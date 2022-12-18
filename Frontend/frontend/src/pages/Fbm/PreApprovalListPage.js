import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useContext } from "react";
import ProfileSummary from "../../components/common/ProfileSummary";
import ActionButtons from "../../components/common/ActionButtons";
import PreApprovalList from "../../components/PreApprovalList/PreApprovalList";
import FbmContext from "../../context/FbmContext/FbmContext";

function PreApprovalListPage() {
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
              id={fbmData.bilkentId}
              image={fbmData.image}
              department={fbmData.department}
            />
          </Row>
          <Row className="my-4">
            <ActionButtons role={role} />
          </Row>
        </Col>
        <Col className="mx-3">
          <PreApprovalList/>
        </Col>
      </Row>
    </section>
  );
}

export default PreApprovalListPage;
