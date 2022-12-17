import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import classes from "./LearningAgreementList.module.css";
import { LearningAgreementListContext } from "../../context/LearningAgreementContext/LearningAgreementListContext";
import { useContext, useState } from "react";
import { useNavigate } from "react-router-dom";

function LearningAgreementList() {
  const learningAgreementList = useContext(LearningAgreementListContext);
  const navigate = useNavigate();
  console.log(learningAgreementList);

  const selectDownloadNumber = (numberSelected) => {
    downloadForm(numberSelected.target.value);
  };

  const selectApproveNumber = (numberSelected) => {
    approve(numberSelected.target.value);
  };

  const selectRejectNumber = (numberSelected) => {
    reject(numberSelected.target.value);
  };
  function handleInput(e) {
    //navigate(`/coordinator/applications/${documentId}`)
  }

  function downloadForm(number) {
    console.log(number);
    var API = `http://localhost:8080/coordinator/learningAgreement/download/${number}`;
    var requestOptions = {
      method: "POST",
      redirect: "follow",
      credentials: "include",
    };

    fetch(API, requestOptions).then((res) => {
      res.blob().then((blob) => {
        // Create blob link to download
        const url = window.URL.createObjectURL(new Blob([blob]));
        const link = document.createElement("a");
        link.href = url;
        link.setAttribute("download", `LearningAgreement.pdf`);
        link.click();
      });
    });
  }

  function approve(number) {
    console.log(number);
    var API = `http://localhost:8080/coordinator/learningAgreement/approve/${number}`;
    var requestOptions = {
      method: "POST",
      redirect: "follow",
      credentials: "include",
    };

    fetch(API, requestOptions).then((res) => {
      window.location.href();
    });
  }

  function reject(number) {
    console.log(number);
    var API = `http://localhost:8080/coordinator/learningAgreement/reject/${number}`;
    var requestOptions = {
      method: "POST",
      redirect: "follow",
      credentials: "include",
    };

    fetch(API, requestOptions).then((res) => {
      window.location.href();
    });
  }

  console.log(learningAgreementList);
  return (
    <Card>
      <h3 className="heading my-3">Learning Agreement List</h3>
      <hr />
      <div className={classes.scrollable}>
        <Table>
          <thead>
            <tr key="head">
              <th className={classes.heading}>Fullname</th>
              <th className={classes.heading}>ID </th>
              <th className={classes.heading}>CGPA</th>
              <th className={classes.heading}>Status</th>
              <th className={classes.heading}>Actions</th>
              <th className={classes.heading}>Download</th>
            </tr>
          </thead>
          <tbody>
            {learningAgreementList.map((learningAgreement) => (
              <tr key={learningAgreement.documentId}>
                <td className={classes.center}>{learningAgreement.fullname}</td>
                <td className={classes.center}>{learningAgreement.id}</td>
                <td className={classes.center}>{learningAgreement.cgpa}</td>
                <td className={classes.center}>{learningAgreement.status}</td>
                {learningAgreement.status === "WAITING_COORDINATOR" ? (
                  <td className={classes.center}>
                    <Button
                      key={learningAgreement.documentId}
                      value={learningAgreement.documentId}
                      className="btn-success mx-2"
                      onClick={selectApproveNumber}
                    >
                      Approve
                    </Button>
                    <Button
                      key={learningAgreement.documentId}
                      value={learningAgreement.documentId}
                      className="btn-danger mx-2"
                      onClick={selectRejectNumber}
                    >
                      Reject
                    </Button>
                  </td>
                ) : (
                  (<td className={classes.center}>No actions available.</td>)
                )}
                <td className={classes.center}>
                  <Button
                    key={learningAgreement.documentId}
                    value={learningAgreement.documentId}
                    className="button-default"
                    onClick={selectDownloadNumber}
                  >
                    Download
                  </Button>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    </Card>
  );
}

export default LearningAgreementList;
