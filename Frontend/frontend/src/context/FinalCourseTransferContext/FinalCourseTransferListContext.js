import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";

export const FinalCourseTransferListContext = createContext();
export const FinalCourseTransferListProvider = ({ children }) => {
  const [finalCourseTransferList, setFinalCourseTransferList] = useState([]);

  useEffect(() => {
    var API = "http://localhost:8080/iso/students";
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
          setFinalCourseTransferList(data);
        });
    }).catch((e) => {console.log(e)});
  }, [setFinalCourseTransferList]);

  return (
    <FinalCourseTransferListContext.Provider value={finalCourseTransferList}>
      {children}
    </FinalCourseTransferListContext.Provider>
  );
};
export default FinalCourseTransferListContext;