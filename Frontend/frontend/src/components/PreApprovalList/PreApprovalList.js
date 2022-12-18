import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import classes from "./PreApprovalList.module.css";
import { PreApprovalListContext } from "../../context/PreApprovalContext/PreApprovalListContext";
import { useContext, useState } from "react";

function PreApprovalList() {
  const PreApprovalList = useContext(PreApprovalListContext);
  console.log(PreApprovalList);

  const selectDownloadNumber = (numberSelected) => {
    downloadForm(numberSelected.target.value);
  };

  const selectApproveNumber = (numberSelected) => {
    approve(numberSelected.target.value);
  };

  const selectRejectNumber = (numberSelected) => {
    reject(numberSelected.target.value);
  };

  function downloadForm(number) {
    console.log(number);
    var API = `http://localhost:8080/fbm/download/preapproval/${number}`;
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
    };

    fetch(API, requestOptions).then((res) => {
      res.blob().then((blob) => {
        // Create blob link to download
        const url = window.URL.createObjectURL(new Blob([blob]));
        const link = document.createElement("a");
        link.href = url;
        link.setAttribute("download", `PreApprovalForm.pdf`);
        link.click();
      });
    });
  }

  function approve(number) {
    console.log(number);
    var API = `http://localhost:8080/fbm/preapproval/approve/${number}`;
    var requestOptions = {
      method: "POST",
      redirect: "follow",
      credentials: "include",
    };

    fetch(API, requestOptions).then((res) => {
      window.location.reload();
    });
  }

  function reject(number) {
    console.log(number);
    var API = `http://localhost:8080/fbm/preapproval/reject/${number}`;
    var requestOptions = {
      method: "POST",
      redirect: "follow",
      credentials: "include",
    };

    fetch(API, requestOptions).then((res) => {
      window.location.reload();
    });
  }

  console.log(PreApprovalList);
  return (
    <Card>
      <h3 className="heading my-3">PreApproval List</h3>
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
            {PreApprovalList.map((learningAgreement) => (
              <tr key={learningAgreement.documentId}>
                <td className={classes.center}>{learningAgreement.fullname}</td>
                <td className={classes.center}>{learningAgreement.id}</td>
                <td className={classes.center}>{learningAgreement.cgpa}</td>
                <td className={classes.center}>{learningAgreement.status}</td>
                {learningAgreement.status === "WAITING_FBM" ? (
                  <td className={classes.center}>
                    <Button
                      key={`approve-${learningAgreement.documentId}`}
                      value={learningAgreement.documentId}
                      className="btn-success mx-2"
                      onClick={selectApproveNumber}
                    >
                      Approve
                    </Button>
                    <Button
                      key={`reject-${learningAgreement.documentId}`}
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
                    key={`download-${learningAgreement.documentId}`}
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

export default PreApprovalList;
