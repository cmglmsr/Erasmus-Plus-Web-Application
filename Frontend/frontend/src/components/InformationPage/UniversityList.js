import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import classes from "./UniversityList.module.css";
import React, { useState, useEffect } from "react";
function UniversityList() {
  return (
    <Card>
      <h3 className={classes.heading}>University List</h3>
      <div className={classes.scrollable}>
        <Table>
          <thead>
            <tr>
              <th className={classes.heading}>University Name</th>
              <th className={classes.heading}>Country</th>
              <th className={classes.heading}>Language</th>
              <th className={classes.heading}>Courses Taught in English</th>
              <th className={classes.heading}>Coordinator</th>
              <th className={classes.heading}>Quota</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
              <td>d</td>
              <td>e</td>
              <td>f</td>
            </tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
              <td>d</td>
              <td>e</td>
              <td>f</td>
            </tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
              <td>d</td>
              <td>e</td>
              <td>f</td>
            </tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
              <td>d</td>
              <td>e</td>
              <td>f</td>
            </tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
              <td>d</td>
              <td>e</td>
              <td>f</td>
            </tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
              <td>d</td>
              <td>e</td>
              <td>f</td>
            </tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
              <td>d</td>
              <td>e</td>
              <td>f</td>
            </tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
              <td>d</td>
              <td>e</td>
              <td>f</td>
            </tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
              <td>d</td>
              <td>e</td>
              <td>f</td>
            </tr>
            <tr>
              <td>a</td>
              <td>b</td>
              <td>c</td>
              <td>d</td>
              <td>e</td>
              <td>f</td>
            </tr>
          </tbody>
        </Table>
      </div>
    </Card>
  );
}

export default UniversityList;
