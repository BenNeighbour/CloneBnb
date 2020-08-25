import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Divider from "@material-ui/core/Divider";
import "./MainSection.css";

interface Props extends RouteComponentProps<any> {
  title: string;
  longDescription: string;
}

const MainSection: React.FC<Props> = (props) => {
  return (
    <div className="mainSection">
      <h2
        style={{
          fontWeight: "normal",
        }}
      >
        {props.title}
      </h2>
      <br />
      <Divider />
      <br />
      <p>{props.longDescription}</p>
      <br />
      <Divider />
      <br />
      Amenities Section Here
      <br />
      <Divider />
      <br />
      Available Calendar
      <br />
      <Divider />
      <br />
      Review Section
    </div>
  );
};

export default MainSection;
