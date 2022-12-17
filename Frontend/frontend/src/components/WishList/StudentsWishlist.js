import { FormCheck } from "react-bootstrap";
import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import { Checkbox } from 'react-bootstrap';
import classes from "./StudentsWishlist.module.css";
import React, { useState, useEffect } from "react";
import Form from "react-bootstrap/Form";

const approvedCourses = [];



function StudentsWishlist() {

  const [userinfo, setUserInfo] = useState({
    courses: [],
    response: [],
  });
  
  const handleChange = (e) => {
    // Destructuring
    const { value, checked } = e.target;
    const { courses } = userinfo;
      
    console.log(`${value} is ${checked}`);

    if(checked){
      approvedCourses.push(value);
    }
    
     
    // Case 1 : The user checks the box
    if (checked) {
      setUserInfo({
        courses: [...courses, value],
        response: [...courses, value],
      });
    }
  
    // Case 2  : The user unchecks the box
    else {
      setUserInfo({
        courses: courses.filter((e) => e !== value),
        response: courses.filter((e) => e !== value),
      });
    }
  };
 

  const courses = [
    {
      courseName: "Mathematic",
      courseCode: "MATH230",
      university: "Bilkent University",
    },
    {
      courseName: "Psychology",
      courseCode: "PSYC100",
      university: "Bilkent University",
    },
    {
      courseName: "Physics",
      courseCode: "PHYS101",
      university: "Bilkent University",
    },
    {
      courseName: "English",
      courseCode: "ENG401",
      university: "Bilkent University",
    },
    {
      courseName: "Humanity",
      courseCode: "HUM112",
      university: "Bilkent University",
    },
  ];

  return (
    <Form  className="form" >
    <Card>
      <h3 className="heading my-3">Aslı Karaman's WishList</h3>
      <hr />
      <div className={classes.scrollable}>
        <Table>
          <thead>
            <tr key="head">
              <th>Course Name</th>
              <th>Course Code </th>
              <th>University</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {courses.map((course) => (
              <tr key={course.uid}>
                <td>{course.courseName}</td>
                <td>{course.courseCode}</td>
                <td>{course.university}</td>
                <td>
                  <div className="form-check">
                    <input
                      className="form-check-input"
                      type="checkbox"
                      id= {course.name}
                      value = {JSON.stringify(course)}
                      
                      onChange={handleChange}
                    />
                  </div>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
        <Button className={classes.button} type="submit">
          APPROVE SELECTED COURSES
        </Button>
      </div>
    </Card>
    </Form>
  );
}

export default StudentsWishlist;
