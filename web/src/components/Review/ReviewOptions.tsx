import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";
import "./Review.css";
import Divider from "@material-ui/core/Divider";

interface Props extends RouteComponentProps<any> {
  staysToBeReviewed: any;
}

const ReviewOptions: React.FC<Props> = (props) => {
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
              <>
                <div
                  className="stayBtn"
                  style={{
                    cursor: "pointer",
                  }}
                  key={index}
                >
                  <p
                    style={{
                      padding: "20px",
                      color: "#484848",
                    }}
                  >
                    {stay.listing.name}
                  </p>
                </div>
                <Divider />
              </>
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
    </div>
  );
};

export default ReviewOptions;
