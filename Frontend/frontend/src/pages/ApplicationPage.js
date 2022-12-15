import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ApplicationDetails from "../components/ApplicationPage/ApplicationDetails";
import ProfileSummary from "../components/common/ProfileSummary";
import ActionButtons from "../components/common/ActionButtons";
import StudentContext from "../context/StudentContext/StudentContext";
import { useContext } from "react";

const DUMMY_APPLICATION = {
  id: "1",
  email: "elifsena.oz@ug.bilkent.edu.tr",
  address: "Döşemealtı / Antalya",
  phone: "+905056547992",
};

function Application(props) {
  const [studentData, role] = useContext(StudentContext);

  function onApplicationSubmitHandler(applicationData) {
    fetch(
      "https://react-course-bd5d1-default-rtdb.firebaseio.com/meetups.json", //enter api address
      {
        method: "POST",
        credentials: 'same-origin',
        body: JSON.stringify(applicationData),
        headers: {
          "Content-Type": "application/json"
        },
      }
    ).then((response) => {
      response.json().then((parsedJson) => {
        console.log(parsedJson);
      });
    });
  }
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
        <Row>
            <ProfileSummary
              name={studentData.name}
              surname={studentData.surname}
              role={role}
              term={studentData.term}
              bilkentId={studentData.bilkentId}
              image={studentData.image}
              department={studentData.department}
            />
          </Row>
          <Row className="my-4">
            <ActionButtons role={role} />
          </Row>
        </Col>
        <Col className="mx-4">
          <ApplicationDetails application={DUMMY_APPLICATION} onApplicationSubmit={onApplicationSubmitHandler}/>
        </Col>
      </Row>
    </section>
  );
}
export default Application;
