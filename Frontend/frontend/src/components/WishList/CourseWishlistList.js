import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import classes from "./CourseWishlistList.module.css";
import { useContext } from "react";
import { useNavigate } from "react-router-dom";
import CourseWishlistContext from "../../context/CourseWishlistContext/CourseWishlistContext";

function CourseWishlistList() {
  const courseWishlist = useContext(CourseWishlistContext);
  const navigate = useNavigate();

  function view(e) {
    console.log(e.target.value);
    const uid = e.target.value;
    navigate(`/insturctor/wishlist/${uid}`) //studentid
  };

  function approve(event) {
    var number = event.target.value;
    var API = `http://localhost:8080/instructor/wishlist/approve/${number}`; //studentid
    var requestOptions = {
      method: "POST",
      redirect: "follow",
      credentials: "include",
    };

    fetch(API, requestOptions).then((res) => {
      window.location.reload();
    });
  }

  function reject(event) {
    var number = event.target.value;
    var API = `http://localhost:8080/instructor/wishlist/reject/${number}`; //studentid
    var requestOptions = {
      method: "POST",
      redirect: "follow",
      credentials: "include",
    };

    fetch(API, requestOptions).then((res) => {
      window.location.reload();
    });
  }

  return (
    <Card>
      <h3 className="heading my-3">Applications List</h3>
      <hr />
      <div className={classes.scrollable}>
        <Table>
        <thead>
            <tr key="head">
              <th className={classes.heading}>Fullname</th>
              <th className={classes.heading}>ID </th>
              <th className={classes.heading}>Status</th>
              <th className={classes.heading}>Actions</th>
              <th className={classes.heading}>View</th>
            </tr>
          </thead>
          <tbody>
            {courseWishlist.map((wishlist) => (
              <tr key={wishlist.id}>
                <td className={classes.center}>{wishlist.fullname}</td>
                <td className={classes.center}>{wishlist.id}</td>
                <td className={classes.center}>{wishlist.status}</td>
                {wishlist.status === "WAITING_INSTRUCTOR" ? (
                  <td className={classes.center}>
                    <Button
                      key={`approve-${wishlist.id}`}
                      value={wishlist.id}
                      className="btn-success mx-2"
                      onClick={approve}
                    >
                      Approve
                    </Button>
                    <Button
                      key={`reject-${wishlist.id}`}
                      value={wishlist.id}
                      className="btn-danger mx-2"
                      onClick={reject}
                    >
                      Reject
                    </Button>
                  </td>
                ) : (
                  (<td className={classes.center}>No actions available.</td>)
                )}
                <td className={classes.center}>
                  <Button
                    key={`download-${wishlist.id}`}
                    value={wishlist.id}
                    className="button-default"
                    onClick={view}
                  >
                    View
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

export default CourseWishlistList;
