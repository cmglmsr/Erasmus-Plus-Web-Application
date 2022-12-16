import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import ApplicationListContext from "../context/ApplicationContext/ApplicationListContext";
import { useContext } from "react";
import ProfileSummary from "../components/common/ProfileSummary";
import CoordinatorContext from "../context/CoordinatorContext/CoordinatorContext";
import { useParams } from "react-router-dom";
import ActionButtons from "../components/common/ActionButtons";
import ApplicationDetailsCoordinator from "../components/ApplicationPage/ApplicationDetailsCoordinator";

function SingleApplicationView() {
  const [coordinatorData, role] = useContext(CoordinatorContext);
  const applicationData = useContext(ApplicationListContext);
  const params = useParams();
  const application = applicationData.filter(
    (application) => application.id === params.id
  )[0];

  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <Row>
            <ProfileSummary
              name={coordinatorData.name}
              surname={coordinatorData.surname}
              role={role}
              term=""
              id={coordinatorData.bilkentId}
              image={coordinatorData.image}
              department={coordinatorData.department}
            />
          </Row>
          <Row className="my-4">
            <ActionButtons role={role} />
          </Row>
        </Col>
        <Col className="mx-3">
          <ApplicationDetailsCoordinator
            fullname={application.fullname}
            id={application.id}
            school={application.school}
            term={application.timePeriod}
            status={application.status}
            uid={application.uid}
            pref1={application.pref1}
            pref2={application.pref2}
            pref3={application.pref3}
            pref4={application.pref4}
            pref5={application.pref5}
            cgpa={application.cgpa}
          />
        </Col>
      </Row>
    </section>
  );
}
export default SingleApplicationView;
