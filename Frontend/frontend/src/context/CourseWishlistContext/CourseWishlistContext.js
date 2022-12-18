import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";

export const CourseWishlistContext = createContext();
export const CourseWishlistProvider = ({ children }) => {
  const [courseWishlist, setsetCourseWishlist] = useState([]);
  const [students, setStudents] = useState([]);

  useEffect(() => {
    var API = "http://localhost:8080/instructor/wishlists";
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
      headers: {
        "Content-Type": "application/json",
      },
    };

    fetch(API, requestOptions)
      .then((res) => {
        res.json().then((data) => {
          var wishlists = [];
          var students = [];
          data.map((student) => {
            var wishlist = student.courseWishlist;
            if (wishlist.length !== 0) {
              wishlists.push(wishlist);
              var info = {
                fullname: student.name + " " + student.surname,
                id : student.id,
                bilkentId: student.bilkentId
              }
              students.push(info);
            }
          });
          setsetCourseWishlist(wishlists);
          setStudents(students);
        });
      })
      .catch((e) => {
        console.log(e);
      });
  }, [setsetCourseWishlist, setStudents]);

  return (
    <CourseWishlistContext.Provider value={{courseWishlist, students}}>
      {children}
    </CourseWishlistContext.Provider>
  );
};
export default CourseWishlistContext;
