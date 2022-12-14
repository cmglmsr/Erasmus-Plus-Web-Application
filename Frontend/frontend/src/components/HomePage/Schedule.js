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
          <th>Due time</th>
          <th>Task</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td></td>
          <td></td>
          <td></td>
        
        </tr>
        <tr>
          <td>2</td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td>3</td>
          <td></td>
          <td></td>
          <td></td>
      
        </tr>
        <tr>
          <td>4</td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td>5</td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td>6</td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td>7</td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        </tbody>
        </Table>
      </div>
    </Card>
  );
}
export default Schedule;
