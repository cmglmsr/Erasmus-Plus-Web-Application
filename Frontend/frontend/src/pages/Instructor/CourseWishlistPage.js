import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useContext } from "react";
import ProfileSummary from "../../components/common/ProfileSummary";
import ActionButtons from "../../components/common/ActionButtons";
import CourseWishlistList from "../../components/WishList/CourseWishlistList";
import InstructorContext from "../../context/InstructorContext/InstructorContext";

function CourseWishlistPage() {
  const [instructorData, role] = useContext(InstructorContext);
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <Row>
            <ProfileSummary
              name={instructorData.name}
              surname={instructorData.surname}
              role={role}
              term=""
              id={instructorData.bilkentId}
              image={instructorData.image}
              department={instructorData.department}
            />
          </Row>
          <Row className="my-4">
            <ActionButtons role={role} />
          </Row>
        </Col>
        <Col className="mx-3">
          <CourseWishlistList />
        </Col>
      </Row>
    </section>
  );
}

export default CourseWishlistPage;
