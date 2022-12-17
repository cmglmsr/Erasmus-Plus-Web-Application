import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";

export const ApplicationListContext = createContext();
export const ApplicationListProvider = ({ children }) => {
  const [applicationList, setApplicationList] = useState([]);

  useEffect(() => {
    var API = "http://localhost:8080/coordinator/applications";
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
          console.log("AAAAAAAAAAAAAAAAAA" + data)
        });
    }).catch((e) => {console.log(e)});
  }, [setApplicationList]);

  console.log(applicationList);
  return (
    <ApplicationListContext.Provider value={applicationList}>
      {children}
    </ApplicationListContext.Provider>
  );
};
export default ApplicationListContext;
