import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import classes from "./LearningAgreementList.module.css";
import { LearningAgreementListContext } from "../../context/LearningAgreementContext/LearningAgreementListContext";
import { useContext } from "react";
import { useNavigate } from "react-router-dom";


function LearningAgreementList(){
  const learningAgreementList = useContext(LearningAgreementListContext);
  const navigate = useNavigate();
  console.log(learningAgreementList);

  function handleInput(e) {
    console.log(e.target.value);
    const uid = e.target.value;
    //navigate(`/coordinator/applications/${uid}`)
  };
  
  console.log(learningAgreementList);
  return (
    <Card>
      <h3 className="heading my-3">Learning AgreementList List</h3>
      <hr />
      <div className={classes.scrollable}>
        <Table>
          <thead>
            <tr key="head">
              <th>Fullname</th>
              <th>ID </th>
              <th>CGPA</th>
              <th>DownLoad</th>
              <th>Approve/Disapprove</th>
            </tr>
          </thead>
          <tbody>
            {learningAgreementList.map((learningAgreement) => (
              <tr key={learningAgreement.uid}>
                <td>{learningAgreement.fullname}</td>
                <td>{learningAgreement.id}</td>
                <td>{learningAgreement.cgpa}</td>
                <td>
                  <Button key={learningAgreement.uid} value={learningAgreement.uid} className="button-default" onClick={e => handleInput(e, "value")}>Download</Button>
                </td>
                <td>
                  <Button key={learningAgreement.uid} value={learningAgreement.uid} className="button-default" onClick={e => handleInput(e, "value")}>Approve</Button>
                  <Button key={learningAgreement.uid} value={learningAgreement.uid} className="button-default" onClick={e => handleInput(e, "value")}>Disapprove</Button>
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