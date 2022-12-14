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
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td></td>
            <td></td>
            <td></td>
          </tr>
        </tbody>
      </Table>
    </Card>
  );
}

export default CourseList;
