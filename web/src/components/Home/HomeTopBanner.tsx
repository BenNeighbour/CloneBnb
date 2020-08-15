import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import SearchBar from "./../Common/SearchBar/SearchBar";

interface Props extends RouteComponentProps<any> {}

const HomeTopBanner: React.FC<Props> = (props) => {
  return (
    <div
      style={{
        width: "100%",
        height: "85vh",
        overflowX: "hidden",
        backgroundColor: "transparent",
        backgroundImage: 'url("./the-alps.jpg")',
        backgroundSize: "cover"
      }}
    >
      <SearchBar
        location={props.location}
        history={props.history}
        match={props.match}
      />
    </div>
  );
};

export default HomeTopBanner;
