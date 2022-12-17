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

var ApprovedCourses = [];

var course = "";
function ApprovedCoursesList(props) {

  const [courseName, setCourseName] = useState("");
  const [courseCode, setCourseCode] = useState("");
  const [hostUniversityName, setUniversity] = useState("");
  const [approvedNotapproved, setApprovedNotapproved] = useState("")
  const [coursesList, setCoursesList] = useState([])

  useEffect(() => {
   course = {courseName: courseName, courseCode: courseCode, hostUniversityName: hostUniversityName, approvedNotapproved: "Approved"};
   props.getCourse(course)
    fetch(
        "http://localhost:8080/student/approvedCoursesList", //enter api address
        {
          method: "GET",
          credentials: "include"
        }
    ).then(res => res.json()).then(result => {
      setCoursesList(result);
    });
  },[courseName, courseCode, hostUniversityName, "Approved"]);

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
              {coursesList.map((item, i) => {
                return (
                  <ReactDeleteRow
                    deleteElement={<i className={classes.button}>ADD</i>}
                    key={i}
                    data={item}
                    onDelete={(item) => {
                      setCourseName(item.courseName);
                      setCourseCode(item.courseCode);
                      setUniversity(item.hostUniversityName);
                      setApprovedNotapproved("Approved")
                    }}
                  >
                    <td>{item.courseName}</td>
                    <td>{item.courseCode}</td>
                    <td>{item.hostUniversityName}</td>
                    <td>Approved</td>
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
