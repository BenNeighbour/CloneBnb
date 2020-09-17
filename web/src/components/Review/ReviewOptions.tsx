import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";
import "./Review.css";
import Divider from "@material-ui/core/Divider";
import CreateReviewModal from "./CreateReviewModal";

interface Props extends RouteComponentProps<any> {
  staysToBeReviewed: any;
}

const ReviewOptions: React.FC<Props> = (props) => {
  const [isCreatingReview, setIsCreatingReview]: any = React.useState(false);
  const [reviewingListingName, setListingName]: any = React.useState(null);

  return (
    <div>
      <Card
        variant="outlined"
        style={{
          boxShadow: "none",
          borderRadius: "none",
        }}
      >
        <CardContent
          style={{
            padding: 0,
          }}
        >
          <Typography
            variant="h2"
            style={{
              color: "#484848",
              backgroundColor: "#edefed",
              fontSize: "16px",
              margin: 0,
              paddingTop: "12px",
              paddingBottom: "12px",
              paddingLeft: "20px",
              paddingRight: "20px",
              lineHeight: "1.1",
            }}
            gutterBottom
          >
            Reviews to write
          </Typography>

          {props.staysToBeReviewed !== undefined || [] ? (
            props.staysToBeReviewed.map((stay: any, index: number) => (
              <div key={index}>
                <div
                  className="stayBtn"
                  style={{
                    cursor: "pointer",
                    overflow: "hidden",
                    verticalAlign: "center",
                  }}
                  onClick={() => {
                    setListingName(stay.listing.name);
                    setIsCreatingReview(true)
                  }}
                >
                  <p
                    style={{
                      padding: "20px",
                      color: "#484848",
                      float: "left",
                    }}
                  >
                    {stay.listing.name}
                  </p>
                  <p
                    style={{
                      padding: "20px",
                      color: "#484848",
                      fontSize: "smaller",
                      float: "right",
                    }}
                  >
                    {new Date(stay.checkInDate).toDateString()} to{" "}
                    {new Date(stay.checkOutDate).toDateString()}
                  </p>
                </div>
                <Divider />
              </div>
            ))
          ) : (
            <p
              style={{
                padding: "20px",
                lineHeight: "1.43",
                color: "#484848",
                fontSize: "14px",
              }}
            >
              Nobody to review right now. Looks like it’s time for another trip!
            </p>
          )}
        </CardContent>
      </Card>

      {isCreatingReview ? (
        <CreateReviewModal
          history={props.history}
          match={props.match}
          location={props.location}
          listingName={reviewingListingName}
          handleClose={() => {
            console.log("close");
            setIsCreatingReview(false);
          }}
          handleSubmit={(rating: number, description: string) => {
            // Call AJAX Method
          }}
        />
      ) : undefined}
    </div>
  );
};

export default ReviewOptions;
