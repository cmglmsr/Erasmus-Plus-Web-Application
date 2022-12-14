import ProfileAction from "../components/common/ProfileAction";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ViewProfile from "../components/ProfilePage/ViewProfile";
import { useEffect } from "react";

const DUMMY_APPLICATION = {
  id: "1",
  name: "Asli",
  surname: "Karaman",
  email: "elifsena.oz@ug.bilkent.edu.tr",
  address: "Döşemealtı / Antalya",
  phone: "+905056547992",
  dateOfBirth: "13.06.2001",
  nationalId: "111111111",
  gender: "female",
  cgpa: "3"
};

function ViewProfilePage(props) {

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
          <ViewProfile profile={DUMMY_APPLICATION}/>
        </Col>
      </Row>
    </section>
  );
}
export default ViewProfilePage;