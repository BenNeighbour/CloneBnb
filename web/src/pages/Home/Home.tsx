import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Navigation from "./../../components/Navigation/Navigation";
import "./Home.css";

interface Props extends RouteComponentProps<any> {}

const Home: React.FC<Props> = (props) => {
  return (
    <div
      style={{
        height: "100%",
      }}
    >
      <Navigation
        isSearchNavbar={true}
        history={props.history}
        match={props.match}
        location={props.location}
      />

      <div
        style={{
          display: "grid",
          placeItems: "center",
          height: "100vh",
        }}
      >
        Hello from Home!
      </div>
    </div>
  );
};

export default Home;
