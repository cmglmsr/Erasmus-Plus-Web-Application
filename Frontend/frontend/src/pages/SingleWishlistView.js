import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import { useContext } from "react";
import ProfileSummary from "../components/common/ProfileSummary";
import ActionButtons from "../components/common/ActionButtons";
import InstructorContext from "../context/InstructorContext/InstructorContext";
import WishlistDetailsInstructor from  "../components/WishList/WishlistDetailsInstructor";
const SingleWishlistView = () => {
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
          <WishlistDetailsInstructor />
        </Col>
      </Row>
    </section>
  );
};
export default SingleWishlistView;
