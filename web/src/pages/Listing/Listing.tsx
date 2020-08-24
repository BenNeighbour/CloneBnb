import { Container } from "@material-ui/core";
import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Navigation from "./../../components/Navigation/Navigation";
import Grid from "@material-ui/core/Grid";
import BookingCard from "./../../components/Listing/BookingCard";

interface Props extends RouteComponentProps<any> {}

const Listing: React.FC<Props> = (props) => {
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
      <Container maxWidth="md">
        {/* Layout here */}
        <div
          style={{
            display: "inline-block",
            marginTop: "10vh",
          }}
        >
          {/* Top Section here */}
          <div
            style={{
              paddingBottom: "3vh",
            }}
          >
            <img
              style={{
                maxWidth: "100%",
                maxHeight: "100%",
                objectFit: "cover",
                objectPosition: "100% 0",
                borderRadius: "10px",
              }}
              alt=""
              src="https://a0.muscache.com/im/pictures/2bda3dae-6ddc-4215-8728-c76c62bebc64.jpg?aki_policy=xx_large"
            />
          </div>

          <Grid
            container
            spacing={2}
            style={{
              overflowX: "hidden",
            }}
          >
            <Grid
              item
              xs={12}
              sm={7}
              style={{
                position: "relative",
              }}
            >
              dfdfgdfgdf
            </Grid>
            <Grid item xs={12} sm={5}>
              <BookingCard
                location={props.location}
                history={props.history}
                match={props.match}
              />
            </Grid>
          </Grid>
        </div>
      </Container>
    </div>
  );
};

export default Listing;
