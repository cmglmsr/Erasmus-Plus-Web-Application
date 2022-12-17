import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useContext } from "react";
import ProfileSummary from "../components/common/ProfileSummary";
import ActionButtons from "../components/common/ActionButtons";
import CoordinatorContext from "../context/CoordinatorContext/CoordinatorContext";
import { useState } from "react";
import StudentsWishlist from "../components/WishList/StudentsWishlist"

function StudentsWishlistPage() {
  //const [coordinatorData, role] = useContext(CoordinatorContext);
  const [profile, setProfile] = useState({});
  const [role, setRole] = useState("");
  return (
    <section>
      <Row>
      <Col xs={3} className="mx-3">
          <Row>
            <ProfileSummary
              name={profile.name}
              surname={profile.surname}
              role={role}
              semester={profile.image}
              id={profile.id}
              image={profile.image}
              department={profile.department}
            />
          </Row>
          <Row className="my-4">
            <ActionButtons role={role} />
          </Row>
        </Col>
        <Col className="mx-3">
          <StudentsWishlist/>
        </Col>
      </Row>
    </section>
  );
}

export default StudentsWishlistPage;
