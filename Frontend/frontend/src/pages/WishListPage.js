import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import CourseList from "../components/InformationPage/CourseList";
import UniversityList from "../components/InformationPage/UniversityList";
import ApprovedCourseList from "../components/WishList/ApprovedCoursesList";
import ProfileAction from "../components/common/ProfileAction";
import StudentCourseList from "../components/WishList/StudentsCourseList";
import UnapprovedCourse from "../components/WishList/UnapprovedCourse";
import ProfileSummary from "../components/common/ProfileSummary";
import { useEffect, useState } from "react";
import ApprovedCoursesList from "../components/WishList/ApprovedCoursesList";
import StudentContext from "../context/StudentContext/StudentContext";
import { useContext } from "react";
function WishListPage() {
  const [profile, role] = useContext(StudentContext);
  console.log(profile);

  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <Row>
            <ProfileSummary
              name={profile.name}
              surname={profile.surname}
              role={role}
              term={profile.term}
              bilkentId={profile.bilkentId}
              image={profile.image}
              department={profile.department}
            />
          </Row>
        </Col>
        <Col className="mx-4">
          <div>
            <Row className="mx-5">
              <StudentCourseList></StudentCourseList>
            </Row>
          </div>
        </Col>
      </Row>
    </section>
  );
}

export default WishListPage;
