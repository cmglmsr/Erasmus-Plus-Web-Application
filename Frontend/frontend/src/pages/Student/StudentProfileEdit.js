import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useContext } from "react";
import ProfileSummary from "../../components/common/ProfileSummary";
import ActionButtons from "../../components/common/ActionButtons";
import StudentContext from "../../context/StudentContext/StudentContext";
import ViewProfile from "../../components/ProfilePage/ViewProfile";
import ProfileDetails from "../../components/ProfilePage/ProfileDetails";

function StudentProfileEdit() {
  const [studentData, role] = useContext(StudentContext);

  console.log(studentData);
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
          <div>
            <Row className="my-3">
              <ProfileDetails
                name={studentData.name}
                surname={studentData.surname}
                phoneNumber={studentData.phoneNumber}
                mail={studentData.mail}
                dateOfBirth={studentData.dateOfBirth}
                gender={studentData.gender}
                cgpa={studentData.cgpa}
                nationalID={studentData.nationalID}
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
export default StudentProfileEdit;
