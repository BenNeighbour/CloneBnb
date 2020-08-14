import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import "./SearchBar.css";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";

interface Props extends RouteComponentProps<any> {}

const HomeTopBanner: React.FC<Props> = (props) => {
  return (
    <div
      style={{
        margin: "0 auto",
        textAlign: "center",
        display: "inline-block",
      }}
    >
      <Card
        style={{
          display: "grid",
          borderRadius: "32px",
          width: "65vw",
          minHeight: "7vh",
        }}
        className="search"
        variant="outlined"
      >
        <CardContent
          style={{
            display: "flex",
            placeItems: "center",
            padding: 0,
          }}
        >
          <div
            style={{
              paddingTop: "0.5vh",
              paddingBottom: "0.5vh",
              flex: "1 0 0",
              paddingRight: "1vw",
              paddingLeft: "2vw"
            }}
          >
            {/* Material Standard Inuput field */}
            <TextField fullWidth color={undefined} focused label="Location" />
          </div>

          <div
            style={{
              paddingTop: "0.5vh",
              paddingBottom: "0.5vh",
              paddingRight: "1vw"
            }}
          >
            {/* TODO: Create a datepicker here! */}
            <TextField fullWidth focused label="Check in" />
          </div>

          <div
            style={{
              paddingTop: "0.5vh",
              paddingBottom: "0.5vh",
              paddingRight: "1vw"
            }}
          >
            {/* TODO: Create a datepicker here! */}
            <TextField fullWidth focused label="Check out" />
          </div>

          <div
            style={{
              paddingTop: "0.5vh",
              paddingBottom: "0.5vh",
              paddingRight: "1vw"
            }}
          >
            <Button
              style={{
                borderRadius: "35px",
                width: "min-content",
                padding: "6px",
                marginLeft: "auto",
                boxShadow: "none",
                textTransform: "none"
              }}
              color="primary"
              variant="contained"
              className="profile-button"
              fullWidth
            >
              Search
            </Button>
          </div>
        </CardContent>
      </Card>
    </div>
  );
};

export default HomeTopBanner;
