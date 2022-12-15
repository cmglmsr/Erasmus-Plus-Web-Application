import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useContext } from "react";
import Schedule from "../components/HomePage/Schedule";
import ProfileSummary from "../components/common/ProfileSummary";
import ActionButtons from "../components/common/ActionButtons";
import StudentContext from "../context/StudentContext";
import ViewProfile from "../components/ProfilePage/ViewProfile";
function StudentProfile() {
  const studentData = useContext(StudentContext);

  console.log(studentData);
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <Row>
          <ProfileSummary
              name={studentData.name}
              surname={studentData.surname}
              role={studentData.role}
              semester={studentData.image}
              id={studentData.id}
              image={studentData.image}
              department={studentData.department}
            />
          </Row>
          <Row className="my-4">
            <ActionButtons role={studentData.role} />
          </Row>
        </Col>
        <Col className="mx-4">
          <div>
            <Row className="my-3">
              <ViewProfile
                name={studentData.name}
                surname={studentData.surname}
                phone={studentData.phone}
                email={studentData.email}
                dateOfBirth={studentData.dateOfBirth}
                gender={studentData.gender}
                cgpa={studentData.cgpa}
                nationalId={studentData.nationalId}
                eng101grade={studentData.eng101grade}
                eng102grade={studentData.eng102grade}
              />
            </Row>
          </div>
        </Col>
      </Row>
    </section>
  );
}
export default StudentProfile;
