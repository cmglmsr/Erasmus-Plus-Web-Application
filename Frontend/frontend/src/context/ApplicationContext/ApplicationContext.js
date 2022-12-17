import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";
import { useParams } from "react-router-dom";

export const ApplicationContext = createContext();
export const ApplicationProvider = ({ children }) => {
  const [applicationData, setApplicationData] = useState({});
  const params = useParams();

  useEffect(() => {
    var API = `http://localhost:8080/coordinator/applications/${params.uid}`;
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
          console.log("aaaaaaaaaaaaaaaa" + data);
          setApplicationData(data);
        });
      }
    );
  }, []);

  return (
    <ApplicationContext.Provider value={applicationData}>
      {children}
    </ApplicationContext.Provider>
  );
};
export default ApplicationContext;
