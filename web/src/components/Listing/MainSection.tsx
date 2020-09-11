import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import "./MainSection.css";
import Grid from "@material-ui/core/Grid";
import Divider from "@material-ui/core/Divider";
import Avatar from "@material-ui/core/Avatar";
import CardHeader from "@material-ui/core/CardHeader";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import { createStyles, makeStyles, Theme } from "@material-ui/core";

interface Props extends RouteComponentProps<any> {
  listing: any;
}

const useStyles = makeStyles((theme: Theme) =>
  createStyles({
    media: {
      height: 0,
      paddingTop: '56.25%', // 16:9
    },
    expand: {
      transform: 'rotate(0deg)',
      marginLeft: 'auto',
      transition: theme.transitions.create('transform', {
        duration: theme.transitions.duration.shortest,
      }),
    },
    expandOpen: {
      transform: 'rotate(180deg)',
    },
    avatar: {
      margin: 0
    }
  }),
);

const MainSection: React.FC<Props> = (props) => {
  const classes = useStyles();

  return (
    <div
      className="mainSection"
      style={{
        height: "min-content",
      }}
    >
      <h2
        style={{
          fontWeight: "normal",
        }}
      >
        {props.listing.name}
      </h2>
      <Grid
        item
        style={{
          margin: 0,
          paddingTop: 0,
          width: "100%",
        }}
      >
        <p>{props.listing.longDescription}</p>
        <br />
        <Divider />
        <br />
        Amenities Section Here
        <br />
        <Divider />
        <br />
        <Grid
          container
          style={{
            margin: 0,
            width: "100%",
          }}
        >
          <Grid item xs={12}>
            <Card style={{
              boxShadow: "none"
            }}>
              <CardHeader
                avatar={<Avatar className={classes.avatar}>R</Avatar>}
                title="Reviewer's Name"
                subheader="September 14, 2016"
                action={null}
              />
              <CardContent style={{
                paddingTop: 0,
                marginTop: 0
              }}>
                <p>
                  Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ex
                  laboriosam, illo numquam consectetur aliquid velit. Laudantium
                  neque voluptas tempore nemo sequi deleniti illo, soluta
                  reprehenderit officia unde veniam dolore dolorum. Lorem ipsum
                  dolor sit amet consectetur adipisicing elit. Expedita nisi
                  neque tempora eos dolore itaque animi recusandae earum velit,
                  atque corporis perferendis tempore dicta ipsam sint ducimus
                  quia, eum eaque.
                </p>
              </CardContent>
            </Card>
          </Grid>
        </Grid>
        <div
          style={{
            paddingBottom: "100vh",
          }}
        ></div>
      </Grid>
    </div>
  );
};

export default MainSection;
