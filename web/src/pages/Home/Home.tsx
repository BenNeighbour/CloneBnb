import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Navigation from "./../../components/Navigation/Navigation";
import "./Home.css";
import HomeTopBanner from "./../../components/Home/HomeTopBanner";

interface Props extends RouteComponentProps<any> {}

const Home: React.FC<Props> = (props) => {
  return (
    <div
      style={{
        height: "100vh",
        width: "100vw",
        display: "grid"
      }}
    >
      <Navigation
        isSearchNavbar={true}
        history={props.history}
        match={props.match}
        location={props.location}
      />
      <div style={{
        paddingTop: "10vh",
        textAlign: "center"
      }}>
        <HomeTopBanner
          location={props.location}
          match={props.match}
          history={props.history}
        />
      </div>
    </div>
  );
};

export default Home;
