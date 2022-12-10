import ProfileAction from "../components/common/ProfileAction";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ToDoList from "../components/HomePage/ToDoList";
import Schedule from "../components/HomePage/Schedule";

const DUMMY_PROFILE = {
  role: "coordinator",
  image: "https://cdn-icons-png.flaticon.com/512/3135/3135715.png",
  name: "",
  surname: "",
  department: "",
};

function CoordinatorHomePage() {
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <ProfileAction profile={DUMMY_PROFILE} />
        </Col>
        <Col className="mx-3">
          <div class="d-grid gap-3">
            <div class="p-2 bg-light border"><ToDoList/></div>
            <div class="p-2 bg-light border"><Schedule/></div>
          </div>
        </Col>
      </Row>
    </section>
  );
}
export default CoordinatorHomePage;
