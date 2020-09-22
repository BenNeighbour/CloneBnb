import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Grid from "@material-ui/core/Grid";
import Container from "@material-ui/core/Container";
import AdvertCard from "./AdvertCard";

interface Props extends RouteComponentProps<any> {}

const MiddleSection: React.FC<Props> = (props) => {
  return (
    <div>
      <Container maxWidth="md">
        <Grid
          container
          style={{
            paddingBottom: "7vh",
            paddingTop: "5vh",
          }}
        >
          <AdvertCard
            location={props.location}
            history={props.history}
            match={props.match}
            title="Entire Homes"
            description="Comfortable private places, with room for friends or family.e"
          />
          <AdvertCard
            location={props.location}
            history={props.history}
            match={props.match}
            title="Entire Homes"
            description="Comfortable private places, with room for friends or family."
          />
          <AdvertCard
            location={props.location}
            history={props.history}
            match={props.match}
            title="Entire Homes"
            description="Comfortable private places, with room for friends or family."
          />
        </Grid>
      </Container>
    </div>
  );
};

export default MiddleSection;
