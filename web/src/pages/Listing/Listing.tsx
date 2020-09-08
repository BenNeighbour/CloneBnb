import { Container } from "@material-ui/core";
import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Navigation from "./../../components/Navigation/Navigation";
import Grid from "@material-ui/core/Grid";
import BookingCard from "./../../components/Listing/BookingCard";
import MainSection from "./../../components/Listing/MainSection";
import { LISTING_PAGE } from "./../../util/api/AJAX";

interface Props extends RouteComponentProps<any> {}

const Listing: React.FC<Props> = (props) => {
  const [listing, setListing]: any = React.useState({});

  React.useEffect(() => {
    // Make a request to get the listing by that id
    LISTING_PAGE(props.match.params.listingId).then((response: any) => {
      setListing(response.data);
    }).catch((error: any) => {
      props.history.goBack();
    });
  }, [props]);

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
        {/* Layout here */}
        <div
          style={{
            display: "inline-block",
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

          <Grid container direction="row" alignItems="stretch" spacing={9}>
            <Grid
              item
              xs={12}
              sm={7}
              style={{
                position: "relative",
                paddingBottom: 0,
              }}
            >
              {listing !== undefined ? <MainSection
                location={props.location}
                match={props.match}
                history={props.history}
                listing={listing}
              /> : undefined}
            </Grid>
            <Grid item xs={12} sm={5} className="stickyCard">
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
