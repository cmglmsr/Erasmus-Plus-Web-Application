import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";

export const CourseWishlistContext = createContext();
export const CourseWishlistProvider = ({ children }) => {
  const [courseWishlist, setsetCourseWishlist] = useState([]);

  useEffect(() => {
    var API = "http://localhost:8080/instrucor/wishlists";
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
      headers: {
        "Content-Type": "application/json",
      },
    };

    fetch(API, requestOptions).then((res) => {
        res.json().then((data) => {
          setsetCourseWishlist(data);
          console.log(data);
        });
    }).catch((e) => {console.log(e)});
  }, [setsetCourseWishlist]);

  console.log(courseWishlist);
  return (
    <CourseWishlistContext.Provider value={courseWishlist}>
      {children}
    </CourseWishlistContext.Provider>
  );
};
export default CourseWishlistContext;
