import ProfileAction from "../components/common/ProfileAction";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ViewApplication from "../components/ApplicationPage/ApplicationDetails";
import { useEffect } from "react";

const DUMMY_APPLICATION = {
  id: "1",
  email: "elifsena.oz@ug.bilkent.edu.tr",
  address: "Döşemealtı / Antalya",
  phone: "+905056547992",
};

function ViewApplicationPage(props) {

  function onApplicationSubmitHandler(applicationData) {
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
          <ProfileAction profile={props.profile} onApplicationSubmit={onApplicationSubmitHandler}/>
        </Col>
        <Col className="mx-4">
          <ViewApplication application={DUMMY_APPLICATION}/>
        </Col>
      </Row>
    </section>
  );
}
export default ViewApplicationPage;