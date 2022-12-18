import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";

export const WaitingListContext = createContext();
export const WaitingListProvider = ({ children }) => {
const [waitingList, setWaitingList] = useState([]);

  useEffect(() => {
    var API = "http://localhost:8080/coordinator/waitlist";
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
          setWaitingList(data);
        });
    }).catch((e) => {console.log(e)});
  }, [setWaitingList]);

  return (
    <WaitingListContext.Provider value={waitingList}>
      {children}
    </WaitingListContext.Provider>
  );
};
export default WaitingListContext;