import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ApplicationForm from "../components/ApplicationPage/ApplicationForm";
import ProfileSummary from "../components/common/ProfileSummary";
import ActionButtons from "../components/common/ActionButtons";
import StudentContext from "../context/StudentContext/StudentContext";
import { useContext } from "react";

function CreateApplication() {
  const [studentData, role] = useContext(StudentContext);

  console.log("ApppplicationPage");
  function onApplicationSubmitHandler(applicationData) {
    fetch(
      "http://localhost:8080/student/createApplication", //enter api address
      {
        method: "POST",
        credentials: "include",
        body: JSON.stringify(applicationData),
        headers: {
          "Content-Type": "application/json",
          "Cookie": document.cookie 
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
          <ApplicationForm
            phoneNumber={studentData.phoneNumber}
            mail={studentData.mail}
            address={studentData.address}
            onApplicationSubmit={onApplicationSubmitHandler}
          />
        </Col>
      </Row>
    </section>
  );
}
export default CreateApplication;
