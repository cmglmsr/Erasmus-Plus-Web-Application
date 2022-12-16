import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";

export const InstructorContext = createContext();
export const InstructorProvider = ({ children }) => {

  const [instructorData, setinstructorData] = useState([]);
  const [role, setRole] = useState("");

  useEffect(() => {
    var API = "http://localhost:8080/instructor/home";
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
        setinstructorData(data);
        setRole(data.role.name);
        localStorage.setItem("role", data.role.name);
      })
    );
  }, []);

  console.log(instructorData);
  return (
    <InstructorContext.Provider value={[instructorData, role]}>
      {children}
    </InstructorContext.Provider>
  );
};
export default InstructorContext;
