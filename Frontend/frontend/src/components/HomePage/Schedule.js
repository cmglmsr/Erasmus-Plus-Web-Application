import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import classes from "./Schedule.module.css";
import React, { useState, useEffect } from 'react';

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
          <td>Eren Duran's preapproval form's confirmation</td>
        
        </tr>
        <tr>
          <td>2</td>
          <td>{dateState.toLocaleDateString('en-GB', {
                 day: 'numeric',
                 month: 'short',
                 year: 'numeric',
              })}</td>
          <td>17.00</td>
          <td>Elifsena Oz's Final Course Transfer Form's submittion</td>
        </tr>
        <tr>
          <td>3</td>
          <td>{dateState.toLocaleDateString('en-GB', {
                 day: 'numeric',
                 month: 'short',
                 year: 'numeric',
              })}</td>
          <td>19.00</td>
          <td>Aslı Karaman's documents' signature</td>
      
        </tr>
        <tr>
          <td>4</td>
          <td>{dateState.toLocaleDateString('en-GB', {
                 day: 'numeric',
                 month: 'short',
                 year: 'numeric',
              })}</td>
          <td>20.00</td>
          <td>Cem Gülümser's elective courses' approvement </td>
        </tr>
      </tbody>
    </Table>
    </Card>
    
  );
}
export default Schedule;
