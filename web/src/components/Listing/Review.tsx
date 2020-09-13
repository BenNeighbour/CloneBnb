import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Grid from "@material-ui/core/Grid";
import Card from "@material-ui/core/Card";
import CardHeader from "@material-ui/core/CardHeader";
import CardContent from "@material-ui/core/CardContent";
import Avatar from "@material-ui/core/Avatar";

interface Props extends RouteComponentProps<any> {
  review: any;
}

const Review: React.FC<Props> = (props) => {
  return (
    <Grid item xs={12}>
      <Card
        style={{
          boxShadow: "none",
        }}
      >
        <CardHeader
          avatar={<Avatar style={{
            padding: 0,
            margin: 0
          }}>R</Avatar>}
          title={props.review.reviewer.username}
          subheader={`${props.review.stars} stars`}
          action={null}
        />
        <CardContent
          style={{
            paddingTop: 0,
            marginTop: 0,
          }}
        >
          <p>
            {props.review.comment}
          </p>
        </CardContent>
      </Card>
    </Grid>
  );
};

export default Review;
