import { useEffect, useMemo } from "react";
import { useState } from "react";
import { createContext } from "react";

export const StudentContext = createContext();
export const StudentProvider = ({ children }) => {
  var API = "http://localhost:8080/student/home";

  const [studentData, setStudentData] = useState([]);

  useEffect(() => {
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
      headers: {
        "Content-Type": "application/json",
      },
    };

    fetch(API, requestOptions).then((res) =>
      res.json().then((data) => {
        setStudentData(data);
      })
    );
  }, []);

  console.log(studentData);
  return (
    <StudentContext.Provider value={studentData}>
      {children}
    </StudentContext.Provider>
  );
};
export default StudentContext;
