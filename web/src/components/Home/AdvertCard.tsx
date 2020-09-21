import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Grid from "@material-ui/core/Grid";
import Typography from "@material-ui/core/Typography";
import * as React from "react";
import { RouteComponentProps } from "react-router-dom";

interface Props extends RouteComponentProps<any> {
  title: string;
  description: string;
}

const AdvertCard: React.FC<Props> = (props) => {
  return (
    <Grid
      item
      xs={12}
      sm={4}
      style={{
        paddingLeft: "1vw",
      }}
    >
      <Card
        style={{
          minHeight: "25vh",
          marginRight: "1vw",
          marginTop: "1vh",
          boxShadow: "rgba(0, 0, 0, 0.15) 0px 2px 8px",
          borderRadius: "17px",
          cursor: "pointer",
          paddingBottom: 0
        }}
      >
        <div>
          <img
            style={{
              maxHeight: "20vh",
              marginBottom: 0,
              border: "none",
              outline: "none",
            }}
            alt=""
            src="https://a0.muscache.com/im/pictures/fdb46962-10c1-45fc-a228-d0b055411448.jpg"
          />
        </div>
        <CardContent>
          <Typography
            variant="h3"
            component="h3"
            style={{
              float: "left",
              paddingLeft: "1vw",
              paddingTop: 0,
            }}
          >
            <b>{props.title}</b>
          </Typography>
          <br />
          <br />
          <Typography variant="body2" color="textSecondary" component="p">
            {props.description}
          </Typography>
        </CardContent>
      </Card>
    </Grid>
  );
};

export default AdvertCard;
