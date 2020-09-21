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
            description="This impressive paella is a perfect party dish and a fun meal
                  to cook together with your guests. Add 1 cup of frozen peas
                  along with the mussels, if you like"
          />
          <AdvertCard
            location={props.location}
            history={props.history}
            match={props.match}
            title="Entire Homes"
            description="This impressive paella is a perfect party dish and a fun meal
                  to cook together with your guests. Add 1 cup of frozen peas
                  along with the mussels, if you like"
          />
          <AdvertCard
            location={props.location}
            history={props.history}
            match={props.match}
            title="Entire Homes"
            description="This impressive paella is a perfect party dish and a fun meal
                  to cook together with your guests. Add 1 cup of frozen peas
                  along with the mussels, if you like"
          />
        </Grid>
      </Container>
    </div>
  );
};

export default MiddleSection;
