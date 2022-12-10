import ProfileAction from "../components/common/ProfileAction";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ToDoList from "../components/HomePage/ToDoList";
import Schedule from "../components/HomePage/Schedule";


function Homepage(props) {
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <ProfileAction profile={props.profile} />
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
export default Homepage;
