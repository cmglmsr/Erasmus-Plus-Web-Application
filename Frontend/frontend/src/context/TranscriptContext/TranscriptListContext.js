import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";

export const TranscriptListContext = createContext();
export const TranscriptListProvider = ({ children }) => {
  const [transcriptList, setTranscriptList] = useState([]);

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
          console.log(data);
          setTranscriptList(data);
        });
    }).catch((e) => {console.log(e)});
  }, [setTranscriptList]);

  return (
    <TranscriptListContext.Provider value={transcriptList}>
      {children}
    </TranscriptListContext.Provider>
  );
};
export default TranscriptListContext;