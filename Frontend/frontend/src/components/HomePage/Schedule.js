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
      <Table striped bordered hover>
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
          <td>{dateState.toLocaleDateString('en-GB', {
                 day: 'numeric',
                 month: 'short',
                 year: 'numeric',
              })}</td>
          <td>16.00</td>
          <td>Submit Eren Duran's transcript</td>
        
        </tr>
        <tr>
          <td>2</td>
          <td>{dateState.toLocaleDateString('en-GB', {
                 day: 'numeric',
                 month: 'short',
                 year: 'numeric',
              })}</td>
          <td>17.00</td>
          <td>Submit Cem Gülümser's transcript</td>
        </tr>
        <tr>
          <td>3</td>
          <td>{dateState.toLocaleDateString('en-GB', {
                 day: 'numeric',
                 month: 'short',
                 year: 'numeric',
              })}</td>
          <td>19.00</td>
          <td>Submit Elifsena Oz's transcript</td>
      
        </tr>
        <tr>
          <td>4</td>
          <td>{dateState.toLocaleDateString('en-GB', {
                 day: 'numeric',
                 month: 'short',
                 year: 'numeric',
              })}</td>
          <td>20.00</td>
          <td>Submit Arda Yıldız's transcript</td>
        </tr>
      </tbody>
    </Table>
    </Card>
    
  );
}
export default Schedule;
