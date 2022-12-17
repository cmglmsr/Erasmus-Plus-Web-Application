import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import { useContext } from "react";
import { useNavigate } from "react-router-dom";
import classes from "./ViewWishlists.module.css"

function ViewWishlists() {
  const wishlists = [
    {
      studentName: "Aslı Karaman",
      department: "Computer Engineering",
    },
    {
      studentName: "Cem Gülümser",
      department: "Computer Engineering",
    },
    {
        studentName: "Elifsena Öz",
        department: "Computer Engineering",
    },
    {
        studentName: "Eren Duran",
        department: "Computer Engineering",
    },
    {
        studentName: "Arda Yıldız",
        department: "Computer Engineering",
    },
  ];
  function viewWishlists() {
    var id = this.key;
    console.log("view" + id);
    //navigate(`/coordinator/applications/${id}`);
  }
  return (
    <Card>
      <h3 className="heading my-3">Wishlists</h3>
      <hr />
      <div className={classes.scrollable}>
        <Table>
          <thead>
            <tr key="head">
              <th>Student Name</th>
              <th>Department </th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {wishlists.map((application) => (
              <tr key={application.uid}>
                <td>{application.studentName}</td>
                <td>{application.department}</td>
                <td>
                  <Button
                    key={application.uid}
                    className="button-default"
                    onClick={viewWishlists}
                  >
                    View WishList
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
export default ViewWishlists;
