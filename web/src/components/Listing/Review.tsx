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
          boxShadow:  "none",
        }}
      >
        <CardHeader
          avatar={<Avatar>R</Avatar>}
          title="Reviewer's Name"
          subheader="September 14, 2016"
          action={null}
        />
        <CardContent
          style={{
            paddingTop: 0,
            marginTop: 0,
          }}
        >
          <p>
            Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ex
            laboriosam, illo numquam consectetur aliquid velit. Laudantium neque
            voluptas tempore nemo sequi deleniti illo, soluta reprehenderit
            officia unde veniam dolore dolorum. Lorem ipsum dolor sit amet
            consectetur adipisicing elit. Expedita nisi neque tempora eos dolore
            itaque animi recusandae earum velit, atque corporis perferendis
            tempore dicta ipsam sint ducimus quia, eum eaque.
          </p>
        </CardContent>
      </Card>
    </Grid>
  );
};

export default Review;
