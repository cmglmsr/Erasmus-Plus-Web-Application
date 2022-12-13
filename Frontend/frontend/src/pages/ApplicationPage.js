import ProfileAction from "../components/common/ProfileAction";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ApplicationDetails from "../components/ApplicationPage/ApplicationDetails";
  function ApplicationPage(props) {
    function applicationHandler(applicationData) {
      fetch(
        "https://react-course-bd5d1-default-rtdb.firebaseio.com/meetups.json", //enter api address
        {
          method: "POST",
          body: JSON.stringify(applicationData),
        }
      );
    }
    return (
      <section>
        <Row>
          <Col xs={3} className="mx-3">
            <ProfileAction profile={props.profile} />
          </Col>
          <Col className="mx-4">
            <ApplicationDetails application={applicationHandler} />
          </Col>
        </Row>
      </section>
    );
  }
  export default ApplicationPage;

