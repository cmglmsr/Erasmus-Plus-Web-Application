import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";

export const PreApprovalListContext = createContext();
export const PreApprovalListProvider= ({ children }) => {
  const [preApprovalList, setPreApprovalList] = useState([]);

  useEffect(() => {
    var API = "http://localhost:8080/fbm/preapprovals";
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
          setPreApprovalList(data);
        });
    }).catch((e) => {console.log(e)});
  }, [setPreApprovalList]);

  return (
    <PreApprovalListContext.Provider value={preApprovalList}>
      {children}
    </PreApprovalListContext.Provider>
  );
};
export default PreApprovalListContext;
