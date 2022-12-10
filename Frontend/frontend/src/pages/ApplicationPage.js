import ProfileAction from "../components/common/ProfileAction";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ApplicationDetails from "../components/ApplicationPage/ApplicationDetails";

const DUMMY_APPLICATION = {
    id: "1",
    email: "elifsena.oz@ug.bilkent.edu.tr",
    address: "Döşemealtı / Antalya",
    phone: "+905056547992",
};

function ApplicationPage(props) {
    return (
      <section>
        <Row>
          <Col xs={3} className="mx-3">
            <ProfileAction profile={props.profile} />
          </Col>
          <Col className="mx-4">
            <ApplicationDetails application={DUMMY_APPLICATION} />
          </Col>
        </Row>
      </section>
    );
  }
  export default ApplicationPage;

