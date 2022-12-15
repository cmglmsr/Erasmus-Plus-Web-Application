import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";

export const ApplicationContext = createContext();
export const ApplicationProvider = ({ children }) => {
  const [applicationData, setApplicationData] = useState([]);

  useEffect(() => {
    var API = "http://localhost:8080/student/getApplication";
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
        console.log("statussss" + res.status);
        if (res.status === 406) {
          window.location.href =
            "http://localhost:3000/student/createApplication";
        } else if (res.status === 200) {
          setApplicationData(data);
        }
      })
    );
  }, []);

  console.log(applicationData);
  return (
    <ApplicationContext.Provider value={applicationData}>
      {children}
    </ApplicationContext.Provider>
  );
};
export default ApplicationContext;
