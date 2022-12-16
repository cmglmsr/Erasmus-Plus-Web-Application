import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";

export const StudentContext = createContext();
export const StudentProvider = ({ children }) => {

  const [studentData, setStudentData] = useState([]);
  const [role, setRole] = useState("");
  const [application, setApplication] = useState([]);

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
        setApplication({
          "id" : data.application.id,
          "pref1" : data.application.school1.name,
          "pref1id" : data.application.school1.id,
          "pref2" : data.application.school2.name,
          "pref2id" : data.application.school2.id,
          "pref3" : data.application.school3.name,
          "pref3id" : data.application.school3.id,
          "pref4" : data.application.school4.name,
          "pref4id" : data.application.school4.id,
          "pref5" : data.application.school5.name,
          "pref5id" : data.application.school5.id,
          "term" : data.application.term,
          "status" : data.application.status,
        })
        localStorage.setItem("role", data.role.name);
      })
    ).catch((e) => {console.log(e);})
  }, []);

  console.log(studentData);
  return (
    <StudentContext.Provider value={[studentData, role, application]}>
      {children}
    </StudentContext.Provider>
  );
};
export default StudentContext;
