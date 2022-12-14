import ProfileSummary from "../components/common/ProfileSummary";
import ActionButtons from "../components/common/ActionButtons";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useEffect, useState } from "react";
import Schedule from "../components/HomePage/Schedule";

function Instructor() {
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

    fetch("http://localhost:8080/instructor/home", requestOptions).then(
      (response) => response.json().then((parsedJson) => setProfile(parsedJson))
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
            <ActionButtons role={profile.role} />
          </Row>
        </Col>
        <Col className="mx-4">
          <div>
            <Row className="my-3">
              <Schedule />
            </Row>
          </div>
        </Col>
      </Row>
    </section>
  );
}
export default Instructor;
