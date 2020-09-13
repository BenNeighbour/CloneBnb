import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Navigation from "./../../components/Navigation/Navigation";
import { Container } from "@material-ui/core";
import "./Review.css";
import ReviewOptions from "./../../components/Review/ReviewOptions";

interface Props extends RouteComponentProps<any> {}

const Review: React.FC<Props> = (props) => {
  return (
    <div
      style={{
        width: "100%",
        display: "grid",
      }}
    >
      <Navigation
        isSearchNavbar={false}
        history={props.history}
        match={props.match}
        location={props.location}
      />
      <Container
        maxWidth="lg"
        style={{
          paddingLeft: "7vw",
          paddingRight: "7vw",
        }}
      >
        <div className="title">Your Reviews</div>
        <br />
        <ReviewOptions
          history={props.history}
          match={props.match}
          location={props.location}
        />
      </Container>
    </div>
  );
};

export default Review;
