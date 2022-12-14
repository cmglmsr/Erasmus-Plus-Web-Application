import ProfileSummary from "../components/common/ProfileSummary";
import ActionButtons from "../components/common/ActionButtons";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ToDoList from "../components/HomePage/ToDoList";
import Schedule from "../components/HomePage/Schedule";
import { useEffect, useState } from "react";

function InternationalStudentOfficePage() {
  const [profile, setProfile] = useState();
  useEffect(() => {
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
      headers: {
        "Content-Type": "application/json",
      },
    };

    fetch("http://localhost:8080/iso/home", requestOptions).then((response) =>
      response.json().then((parsedJson) => setProfile(parsedJson))
    );
  }, []);

  console.log(profile);
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <Row>
            <ProfileSummary
              name={profile.name}
              surname={profile.surname}
              role={profile.role}
              semester={profile.image}
              id={profile.id}
              image={profile.image}
              department={profile.department}
            />
          </Row>
          <Row className="my-4">
            <ActionButtons role={profile.roles[0]} />
          </Row>
        </Col>
        <Col className="mx-4">
          <div>
            <Row>
              <ToDoList />
            </Row>
            <Row className="my-4">
              <Schedule />
            </Row>
          </div>
        </Col>
      </Row>
    </section>
  );
}

export default InternationalStudentOfficePage;
