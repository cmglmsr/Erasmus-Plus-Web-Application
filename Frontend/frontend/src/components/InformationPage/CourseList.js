import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import classes from "./CourseList.module.css";
import React, { useState, useEffect } from "react";
function CourseList() {
  return (
    <Card>
      <h3 className={classes.heading}>Course List</h3>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th className= {classes.heading}>Course Name</th>
            <th className= {classes.heading}>Department</th>
            <th className= {classes.heading}>Mandatory/Elective</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>CS319-Object-Oriented Software Engineering</td>
            <td>Computer Engineering</td>
            <td>Mandatory</td>
          </tr>
          <tr>
            <td>MATH230-Probability and Statistics for Engineers</td>
            <td>Mathematics</td>
            <td>Mandatory</td>
          </tr>
          <tr>
            <td>PSYC100-Introduction to Psychology</td>
            <td>Psychology</td>
            <td>Elective</td>
          </tr>
          <tr>
            <td>CS202</td>
            <td>Computer Engineering</td>
            <td>Mandatory</td>
          </tr>
        </tbody>
      </Table>
    </Card>
  );
}

export default CourseList;
