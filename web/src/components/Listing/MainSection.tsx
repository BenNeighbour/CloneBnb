import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import "./MainSection.css";
import Grid from '@material-ui/core/Grid';
import Divider from '@material-ui/core/Divider';

interface Props extends RouteComponentProps<any> {
  title: string;
}

const MainSection: React.FC<Props> = (props) => {
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
        {props.title}
      </h2>
      <Grid
        item
        xs={12}
        sm={7}
        style={{
          paddingTop: 0,
        }}
      >
        <br />
        <Divider />
        <br />
        <p>xcvcxx</p>
        <br />
        <Divider />
        <br />
        Amenities Section Here
        <br />
        <Divider />
        <br />
        Available Calendar
        <br />
        <Divider />
        <br />
        Review Section
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
