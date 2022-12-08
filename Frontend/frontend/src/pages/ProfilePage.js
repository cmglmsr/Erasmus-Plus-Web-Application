import ProfileSummary from "../components/common/ProfileSummary";
import ActionButtons from "../components/common/ActionButtons";
import Table from "../components/layout/Table";
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
function ProfilePage() {
  return (
    <section>
      <Row>
        <Col xs={3}>
          <Row className="mb-3">
            <ProfileSummary profile={DUMMY_PROFILE} />
          </Row>
          <Row>
            <ActionButtons role={DUMMY_PROFILE.role} />
          </Row>
        </Col>
        <Col>
        </Col>
      </Row>
    </section>
  );
}

export default ProfilePage;
