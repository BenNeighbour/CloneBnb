import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Navigation from "./../../components/Navigation/Navigation";
import { Container } from "@material-ui/core";
import "./Review.css";
import ReviewOptions from "./../../components/Review/ReviewOptions";
import CircularProgress from "@material-ui/core/CircularProgress";
import { REVIEWER_PAGE } from "../../util/api/AJAX";

interface Props extends RouteComponentProps<any> {}

const Review: React.FC<Props> = (props) => {
  const [staysToBeReviewed, setStaysToBeReviewed]: any = React.useState([]);
  const [isLoading, setLoading]: any = React.useState(true);

  React.useEffect(() => {
    REVIEWER_PAGE()
      .then((response: any) => {
        setLoading(false);
        setStaysToBeReviewed(response.data);
      })
      .catch((error: any) => {
        
      });
  }, []);

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
        {!isLoading ? (
          <>
            <div className="title">Your Reviews</div>
            <br />
            <ReviewOptions
              history={props.history}
              match={props.match}
              location={props.location}
              staysToBeReviewed={staysToBeReviewed}
            />
          </>
        ) : (
          <div
            style={{
              placeItems: "center",
              textAlign: "center",
              display: "inline-block",
              width: "94%",
            }}
          >
            <CircularProgress />
          </div>
        )}
      </Container>
    </div>
  );
};

export default Review;
