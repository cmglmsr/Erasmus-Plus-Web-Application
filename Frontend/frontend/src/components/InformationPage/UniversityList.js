import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import classes from "./UniversityList.module.css";
import React, { useState, useEffect } from "react";
function UniversityList() {
  return (
    <Card>
      <h3 className={classes.heading}>University List</h3>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th className= {classes.heading}>University Name</th>
            <th className= {classes.heading}>Country</th>
            <th className= {classes.heading}>Language</th>
            <th className= {classes.heading}>Courses Taught in English</th>
            <th className= {classes.heading}>Coordinator</th>
            <th className= {classes.heading}>Quota</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>EPFL</td>
            <td>Switzerland</td>
            <td>English B2</td>
            <td>Yes</td>
            <td>Ayşegül Dündar</td>
            <td>B.Sc./M.Sc., 2x6 Months</td>
          </tr>
          <tr>
            <td>Virje Universiteit Amsterdam</td>
            <td>The Netherlands</td>
            <td>English B2</td>
            <td>Yes</td>
            <td>Ayşegül Dündar</td>
            <td>B.Sc./M.Sc., 2x6 Months</td>
          </tr>
          <tr>
            <td>EPITA</td>
            <td>France</td>
            <td>English B2</td>
            <td>Very few, late announcements</td>
            <td>Can Alkan</td>
            <td>B.Sc., 2x6 Months</td>
          </tr>
          <tr>
            <td>Kington University</td>
            <td>U.K</td>
            <td>English B2</td>
            <td>Yes FALL SEMESTER ONLY</td>
            <td>Can Alkan</td>
            <td>B.Sc., 2x5 Months</td>
          </tr>
          <tr>
            <td>TELECOM ParisTech</td>
            <td>France</td>
            <td>French B2</td>
            <td>No</td>
            <td>Can Alkan</td>
            <td>M.Sc., 2x5 Months</td>
          </tr>
        </tbody>
      </Table>
    </Card>
  );
}

export default UniversityList;