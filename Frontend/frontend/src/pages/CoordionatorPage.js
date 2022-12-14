import ProfileAction from "../components/common/ProfileAction";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ToDoList from "../components/HomePage/ToDoList";
import Schedule from "../components/HomePage/Schedule";
import { useEffect, useState } from "react";

function Coordinator() {
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

    fetch("http://localhost:8080/coordinator/home", requestOptions).then(
      (response) => response.json().then((parsedJson) => setProfile(parsedJson))
    );
  }, []);

  console.log(profile);
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <ProfileAction profile={profile} />
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
export default Coordinator;
