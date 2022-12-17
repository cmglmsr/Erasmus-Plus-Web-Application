import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import classes from "./Schedule.module.css";
import React, { useState, useEffect } from 'react';
import { Container } from "react-bootstrap";

function Schedule() {
  const [dateState, setDateState] = useState(new Date());
    useEffect(() => {
           setInterval(() => setDateState(new Date()), 30000);
    }, []);
  return (
    <Card>
      <h3 className={classes.heading}>Schedule</h3>
      <div className={classes.scrollable}>
        <Table>
      <thead>
        <tr>
          <th>#</th>
          <th>Due date</th>
          <th>Task</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>01.11.2022</td>
          <td>Erasmus Applications Open for Students</td>

        </tr>
        <tr>
          <td>2</td>
          <td>01.01.2023</td>
          <td>Erasmus Applications Close for Students</td>
        </tr>
        <tr>
          <td>3</td>
          <td>15.01.2023</td>
          <td>Erasmus Application Results Are Announced</td>

        </tr>
        <tr>
          <td>4</td>
          <td>01.02.2023</td>
          <td>Erasmus Applications Finalized</td>
        </tr>
        <tr>
          <td>5</td>
          <td>20.02.2023</td>
          <td>Course Wishlist Creation Deadline for Students</td>
        </tr>
        <tr>
          <td>6</td>
          <td>15.03.2023</td>
          <td>PreApproval Submit Deadline for Students</td>
        </tr>
        <tr>
          <td>7</td>
          <td>01.04.2023</td>
          <td>Learning Agreement Submit Deadline for Students</td>
        </tr>
        </tbody>
        </Table>
      </div>
    </Card>
  );
}
export default Schedule;
