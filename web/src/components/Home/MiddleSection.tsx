import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Grid from "@material-ui/core/Grid";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";
import CardMedia from "@material-ui/core/CardMedia";
import Container from "@material-ui/core/Container";

interface Props extends RouteComponentProps<any> {}

const MiddleSection: React.FC<Props> = (props) => {
  return (
    <div>
      <Container maxWidth="md">
        <Grid
          container
          style={{
            paddingBottom: "7vh",
            paddingTop: "5vh",
          }}
        >
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
              }}
            >
              <CardMedia image="/" title="Thumbnail" />
              <CardContent>
                <Typography variant="body2" color="textSecondary" component="p">
                  This impressive paella is a perfect party dish and a fun meal
                  to cook together with your guests. Add 1 cup of frozen peas
                  along with the mussels, if you like.
                </Typography>
              </CardContent>
            </Card>
          </Grid>
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
              }}
            >
              <CardMedia image="/" title="Thumbnail" />
              <CardContent>
                <Typography variant="body2" color="textSecondary" component="p">
                  This impressive paella is a perfect party dish and a fun meal
                  to cook together with your guests. Add 1 cup of frozen peas
                  along with the mussels, if you like.
                </Typography>
              </CardContent>
            </Card>
          </Grid>
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
              }}
            >
              <CardMedia image="/" title="Thumbnail" />
              <CardContent>
                <Typography variant="body2" color="textSecondary" component="p">
                  This impressive paella is a perfect party dish and a fun meal
                  to cook together with your guests. Add 1 cup of frozen peas
                  along with the mussels, if you like.
                </Typography>
              </CardContent>
            </Card>
          </Grid>
        </Grid>
      </Container>
    </div>
  );
};

export default MiddleSection;
