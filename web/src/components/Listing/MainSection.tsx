import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import "./MainSection.css";
import Grid from "@material-ui/core/Grid";
import Divider from "@material-ui/core/Divider";
import Review from "./Review";

interface Props extends RouteComponentProps<any> {
  listing: any;
}

const MainSection: React.FC<Props> = (props) => {
  return (
    <div
      className="mainSection"
      style={{
        height: "min-content",
      }}
    >
      <h2
        style={{
          fontWeight: "normal",
        }}
      >
        {props.listing.name}
      </h2>
      <Grid
        item
        style={{
          margin: 0,
          paddingTop: 0,
          width: "100%",
        }}
      >
        <p>{props.listing.longDescription}</p>
        <br />
        <Divider />
        <br />
        Amenities Section Here
        <br />
        <Divider />
        <br />
        <Grid
          container
          style={{
            margin: 0,
            width: "100%",
          }}
        >
          {/* Iterate over reviews here */}
          <Review
            location={props.location}
            match={props.match}
            history={props.history}
            review={null}
          />
          <Review
            location={props.location}
            match={props.match}
            history={props.history}
            review={null}
          />
        </Grid>
      </Grid>
    </div>
  );
};

export default MainSection;
