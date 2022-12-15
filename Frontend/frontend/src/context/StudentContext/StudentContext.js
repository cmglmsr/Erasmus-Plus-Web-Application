import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";

export const StudentContext = createContext();
export const StudentProvider = ({ children }) => {

  const [studentData, setStudentData] = useState([]);
  const [role, setRole] = useState("");

  useEffect(() => {
    var API = "http://localhost:8080/student/home";
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
        setRole(data.role.name);
        localStorage.setItem("role", data.role.name);
      })
    );
  }, []);

  console.log(studentData);
  return (
    <StudentContext.Provider value={[studentData, role]}>
      {children}
    </StudentContext.Provider>
  );
};
export default StudentContext;
