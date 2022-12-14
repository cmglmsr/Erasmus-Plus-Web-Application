import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import classes from "./CourseList.module.css";
import React, { useState, useEffect } from "react";
function CourseList() {
  return (
    <Card>
      <h3 className={classes.heading}>Course List</h3>
      <div className={classes.scrollable}>
        <Table>
          <thead>
            <tr>
              <th className={classes.heading}>Course Name</th>
              <th className={classes.heading}>Department</th>
              <th className={classes.heading}>Mandatory/Elective</th>
            </tr>
          </thead>
          <tbody>
            <tr></tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
            </tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
            </tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
            </tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
            </tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
            </tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
            </tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
            </tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
            </tr>
            <tr>
              <td></td>
              <td>b</td>
              <td>c</td>
            </tr>
          </tbody>
        </Table>
      </div>
    </Card>
  );
}

export default CourseList;
