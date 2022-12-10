import ProfileAction from "../components/common/ProfileAction";
import Table from "../components/HomePage/ToDoList";
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';


const DUMMY_PROFILE = 
  {
    role: "coordinator",
    image: "https://media-exp1.licdn.com/dms/image/D4D03AQEdRKW_KFlPHQ/profile-displayphoto-shrink_800_800/0/1665401571688?e=1675900800&v=beta&t=gv1Z-1e1Qwaglyupyd0o10c5YeCiO95fqjnqUtoc6fI",
    name: "Elifsena",
    surname: "Oz",
    department: "CS"
  }

  function Homepage() {
    return (
      <section>
        <Row>
          <Col xs={3} className="mx-3">
            <ProfileAction profile={DUMMY_PROFILE} />
          </Col>
          <Col className="mx-3">
          </Col>
        </Row>
      </section>
    );
  }
export default Homepage;
