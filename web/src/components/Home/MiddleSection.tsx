import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Grid from "@material-ui/core/Grid";

interface Props extends RouteComponentProps<any> {}

const MiddleSection: React.FC<Props> = (props) => {
  return (
    <div>
      <Grid container>
        <Grid
          item
          xs={12}
          sm={4}
          style={{
            backgroundColor: "blue",
          }}
        >
          sdfsd
        </Grid>
        <Grid
          item
          xs={12}
          sm={4}
          style={{
            backgroundColor: "red",
          }}
        >
          adfd
        </Grid>
        <Grid
          item
          xs={12}
          sm={4}
          style={{
            backgroundColor: "green",
          }}
        >
          sdf
        </Grid>
      </Grid>
    </div>
  );
};

export default MiddleSection;
