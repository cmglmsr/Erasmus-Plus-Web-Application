import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";

export const ApplicationSchoolsContext = createContext();
export const ApplicationSchoolsProvider = ({ children }) => {

  const [schoolData, setSchoolData] = useState([]);

  useEffect(() => {
    var API = "http://localhost:8080/student/getSchools";
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
        setSchoolData(data);
      })
    );
  }, []);

  console.log(schoolData);
  return (
    <ApplicationSchoolsContext.Provider value={schoolData}>
      {children}
    </ApplicationSchoolsContext.Provider>
  );
};
export default ApplicationSchoolsContext;
