import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";
import { useNavigate } from "react-router-dom";

export const StudentContext = createContext();
export const StudentProvider = ({ children }) => {
  const [studentData, setStudentData] = useState([]);
  const [role, setRole] = useState("");
  const [application, setApplication] = useState([]);
  const navigate = useNavigate();

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

        if (data.application !== null) {
          var application = {
            id: data.application.uid,
            bilkentId : data.application.id,
            pref1: data.application.school1.name,
            pref1id: data.application.school1.id,
            pref2: data.application.school2.name,
            pref2id: data.application.school2.id,
            pref3: data.application.school3.name,
            pref3id: data.application.school3.id,
            pref4: data.application.school4.name,
            pref4id: data.application.school4.id,
            pref5: data.application.school5.name,
            pref5id: data.application.school5.id,
            term: data.application.term,
            status: data.application.status,
          };
          setApplication(application);
        } else {
          console.log(window.location.href);
          if (
            window.location.href ===
            "http://localhost:3030/student/getApplication"
          ) {
            navigate("../student/createApplication", { replace: true });
          }
        }
      })
    );
  }, [navigate]);

  console.log(studentData);
  return (
    <StudentContext.Provider value={[studentData, role, application]}>
      {children}
    </StudentContext.Provider>
  );
};
export default StudentContext;
