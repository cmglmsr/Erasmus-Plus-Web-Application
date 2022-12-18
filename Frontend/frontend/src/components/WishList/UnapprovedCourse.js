import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Card from "../UI/Card";
import "react-phone-input-2/lib/material.css";
import classes from "./UnapprovedCourse.module.css";
import React, { useState, useEffect } from "react";
import StudentsCourseList from "./StudentsCourseList";
var course = "";
var courseName1 = "";
var courseCode1 = "";
var university1 = "";
function UnapprovedCourseList(props) {
  const [courseName, setCourseName] = useState("");
  const [courseCode, setCourseCode] = useState("");
  const [hostUniversityName, setUniversity] = useState("");
  const [approvedNotapproved, setApprovedNotapproved] = useState("");

  useEffect(() => {
    course = {
      courseName: courseName,
      courseCode: courseCode,
      hostUniversityName: hostUniversityName,
      approvedNotapproved: "Unpproved"
    };
    props.getCourse(course);
  }, [courseName, courseCode, hostUniversityName, "Unpproved"]);


  return (
    <Card>
      <Form className="form">
        <hr />
        <h5>Add an unapproved course</h5>
        <hr />
        <Form.Group as={Row} className="my-3" controlId="formPlaintext">
          <Form.Label column sm="3">
            Course Name
          </Form.Label>
          <Col>
            <Form.Control
              type="text"
              placeholder="Enter course name"
              
              onChange={(item) => {
                courseName1 = item.target.value;
              }}

            />
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="my-3" controlId="formPlaintext">
          <Form.Label column sm="3">
            Course Code
          </Form.Label>
          <Col>
            <Form.Control
              type="text"
              placeholder="Enter course code"
              onChange={(item) => {
                courseCode1 = item.target.value;
              }}
              
            />
          </Col>
        </Form.Group>

        <Form.Group as={Row} className="my-3" controlId="formPlaintext">
          <Form.Label column sm="3">
            Host University
          </Form.Label>
          <Col>
            <Form.Control
              type="text"
              placeholder="Enter university"
              onChange={(item) => {
                university1 = item.target.value;
              }}

            />
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="mt-4" controlId="formPlaintex">
          <Col className="text-center">
            <Button
              clasName={classes.button}
              type= "button"
              onClick={() => {
                setCourseName(courseName1);
                setCourseCode(courseCode1);
                setUniversity(university1);
                approvedNotapproved = "Unapproved"
              }} 
            >
              Add Course
            </Button>
          </Col>
        </Form.Group>
      </Form>
    </Card>
  );
}

export default UnapprovedCourseList;
