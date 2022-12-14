import ApplicationList from "../components/ApplicationListPage/ApplicationList";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ProfileAction from "../components/common/ProfileAction";
import { useEffect } from "react";

function ApplicationListPage(props) {
  useEffect(() => {
    fetch(`https://jsonplaceholder.typicode.com/posts`).then((response) =>
      console.log(response)
    );
  }, []);
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <ProfileAction profile={props.profile} />
        </Col>
        <Col className="mx-3">
          <ApplicationList/>
        </Col>
      </Row>
    </section>
  );
}

export default ApplicationListPage;
