import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";

export const LearningAgreementListContext = createContext();
export const LearningAgreementListProvider = ({ children }) => {
  const [learningAgreementList, setLearningAgreementList] = useState([]);

  useEffect(() => {
    var API = "http://localhost:8080/coordinator/learningAgreements";
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
          setLearningAgreementList(data);
          console.log("AAAAAAAAAAAAAAAAAA" + data)
        });
    }).catch((e) => {console.log(e)});
  }, [setLearningAgreementList]);

  console.log(learningAgreementList);
  return (
    <LearningAgreementListContext.Provider value={learningAgreementList}>
      {children}
    </LearningAgreementListContext.Provider>
  );
};
export default LearningAgreementListContext;
