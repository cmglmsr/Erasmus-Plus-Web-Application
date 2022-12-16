import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";

export const ApplicationContext = createContext();
export const ApplicationProvider = ({ children }) => {
  const [applicationList, setApplicationList] = useState([]);

  useEffect(() => {
    var API = "http://localhost:8080/student/applicationList";
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
          setApplicationList(data);
        });
    });
  }, []);

  console.log(applicationList);
  return (
    <ApplicationContext.Provider value={applicationList}>
      {children}
    </ApplicationContext.Provider>
  );
};
export default ApplicationContext;
