import { Container } from "@material-ui/core";
import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Navigation from "./../../components/Navigation/Navigation";
import Grid from "@material-ui/core/Grid";
import BookingCard from "./../../components/Listing/BookingCard";
import MainSection from "./../../components/Listing/MainSection";

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
      <Container maxWidth="lg" style={{
        paddingLeft: "7vw",
        paddingRight: "7vw"
      }}>
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
            spacing={9}
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
              <MainSection
                location={props.location}
                match={props.match}
                history={props.history}
                title="Cool Apartment"
                longDescription="22nd floor Interior designed, stunning views of the City and Tower of London.
Most of the London landmarks can be seen from the flat with no obstruction.
Lovely open plan sitting room/kitchen separate large double bedroom, large separate bath/shower room. Integrated Sonos sound system, luxury bedding and 5* accommodation. Security tight, 24hr concierge.
Luxury living."
              />
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
