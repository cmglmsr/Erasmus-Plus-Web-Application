import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import React, { useState, useEffect } from "react";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import ReactDeleteRow from "react-delete-row";
import classes from "./ApprovedCoursesList.module.css";
import StudentsCourseList from "./StudentsCourseList";

const ApprovedCourses = [
  { courseName: "aa", courseCode: "bb", university: "cc", approvedNotapproved: "Approved" },
  { courseName: "dd", courseCode: "ee", university: "ff", approvedNotapproved: "Approved" },
  { courseName: "ee", courseCode: "ee", university: "ff", approvedNotapproved: "Approved" },
  ,
];

var course = "";
function ApprovedCoursesList(props) {
  const [courseName, setCourseName] = useState("");
  const [courseCode, setCourseCode] = useState("");
  const [university, setUniversity] = useState("");
  const [approvedNotapproved, setApprovedNotapproved] = useState("")

  useEffect(() => {
   course = {courseName: courseName, courseCode: courseCode, university: university, approvedNotapproved: "Approved"};
   props.getCourse(course)
  },[courseName, courseCode, university, "Approved"]);

  return (
    <div>
      <Card>
        <h3 className="heading my-3">Approved Courses List</h3>
        <hr />
        <div className={classes.scrollable}>
          <Table>
            <thead>
              <tr>
                <th>Course Name</th>
                <th>Course Code </th>
                <th>University</th>
                <th>Approved/Unapproved</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              {ApprovedCourses.map((item, i) => {
                return (
                  <ReactDeleteRow
                    deleteElement={<i className={classes.button}>ADD</i>}
                    key={i}
                    data={item}
                    onDelete={(item) => {
                      setCourseName(item.courseName);
                      setCourseCode(item.courseCode);
                      setUniversity(item.university);
                      setApprovedNotapproved("Approved")
                    }}
                  >
                    <td>{item.courseName}</td>
                    <td>{item.courseCode}</td>
                    <td>{item.university}</td>
                    <td>{item.approvedNotapproved}</td>
                  </ReactDeleteRow>
                );
              })}
            </tbody>
          </Table>
        </div>
      </Card>
    </div>
  );
}

export default ApprovedCoursesList;
