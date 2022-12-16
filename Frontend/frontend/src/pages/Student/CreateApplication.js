import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ApplicationForm from "../../components/ApplicationPage/ApplicationForm";
import ProfileSummary from "../../components/common/ProfileSummary";
import ActionButtons from "../../components/common/ActionButtons";
import StudentContext from "../../context/StudentContext/StudentContext";
import { useContext } from "react";
import { useNavigate} from 'react-router-dom';

function CreateApplication() {
  const navigate = useNavigate();
  const [studentData, role] = useContext(StudentContext);

  function onApplicationSubmitHandler(applicationData) {
    fetch(
      "http://localhost:8080/student/createApplication", //enter api address
      {
        method: "POST",
        credentials: "include",
        body: JSON.stringify(applicationData),
        headers: {
          "Content-Type": "application/json",
          Cookie: document.cookie,
        },
      }
    ).then((response) => {
      if (response.status === 200) {
        window.confirm("Application Created");
        navigate('/student/getApplication');
      }
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
