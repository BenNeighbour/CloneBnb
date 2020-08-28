import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import CardContent from '@material-ui/core/CardContent';
import Card from '@material-ui/core/Card';
import StarBorderRoundedIcon from '@material-ui/icons/StarBorderRounded';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import Grid from '@material-ui/core/Grid';

interface Props extends RouteComponentProps<any> {
    listing: any;
}

const SearchResultCard: React.FC<Props> = (props) => {
  return (
    <Card
      onClick={() => {
        props.history.push("/listing/ccd30e15-4176-4564-b1a9-bdcf20ab1b99");
      }}
      className="listing"
      elevation={0}
      variant="outlined"
      style={{
        width: "100%",
        textAlign: "left",
        border: "none",
        margin: 0,
      }}
    >
      <CardContent>
        <Grid container spacing={3}>
          <Grid item xs={12} sm={4}>
            <img
              style={{
                maxWidth: "100%",
                maxHeight: "100%",
                objectFit: "cover",
                objectPosition: "100% 0",
                borderRadius: "10px",
              }}
              alt=""
              src={props.listing.thumbnailUrl}
            />
          </Grid>
          <Grid
            item
            xs={12}
            sm={7}
            style={{
              position: "relative",
            }}
          >
            <Typography
              color="textSecondary"
              style={{
                paddingBottom: "0.8vh",
              }}
            >
              {props.listing.description}
            </Typography>
            <Typography
              variant="h5"
              component="h2"
              style={{
                letterSpacing: "0.75px",
              }}
            >
              {props.listing.name}
            </Typography>
            <Divider
              style={{
                margin: "10px",
                width: "3vw",
                marginLeft: "0",
              }}
            />
            <Typography variant="body2" component="p">
              {props.listing.numberOfGuests} guests &bull; {props.listing.numberOfBedrooms}{" "}
              bedrooms &bull; {props.listing.numberOfBeds} beds &bull;{" "}
              {props.listing.numberOfBathrooms} bathrooms
              <br />
              Amenities &bull; in &bull; the &bull; same &bull; format
            </Typography>

            {/* Number of average stars/ */}
            <div
              style={{
                bottom: 0,
                width: "fit-content",
                left: 0,
                display: "inline-block",
                whiteSpace: "nowrap",
                overflowX: "auto",
                overflowY: "hidden",
                listStyle: "none",
                placeItems: "center",
              }}
            >
              <div
                style={{
                  margin: 0,
                  width: "min-content",
                  padding: 0,
                  whiteSpace: "nowrap",
                  overflowX: "auto",
                  listStyle: "none",
                  overflow: "hidden",
                  lineHeight: 1.3,
                  placeItems: "center",
                  textAlign: "center",
                  display: "flex",
                  justifyContent: "center",
                  alignItems: "center",
                }}
              >
                <StarBorderRoundedIcon
                  style={{
                    display: "inline-block",
                    padding: 0,
                    margin: 0,
                    marginRight: ".5vw",
                  }}
                />
                <p
                  style={{
                    display: "inline-block",
                  }}
                >
                  {props.listing.averageStars}
                </p>
              </div>
            </div>
          </Grid>
        </Grid>
      </CardContent>
    </Card>
  );
};

export default SearchResultCard;
