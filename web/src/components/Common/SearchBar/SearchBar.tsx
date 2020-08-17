import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import {
  KeyboardDatePicker,
  MuiPickersUtilsProvider,
} from "@material-ui/pickers";
import DateFnsUtils from "@date-io/date-fns";

interface Props extends RouteComponentProps<any> {}

const SearchBar: React.FC<Props> = (props) => {
  return (
    <MuiPickersUtilsProvider utils={DateFnsUtils}>
      <div
        style={{
          margin: "0 auto",
          textAlign: "center",
          display: "inline-block",
          marginTop: "10vh",
        }}
      >
        <Card
          style={{
            display: "grid",
            borderRadius: "32px",
            maxWidth: "70vw",
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
                paddingLeft: "2vw",
              }}
            >
              {/* Material Standard Inuput field */}
              <TextField fullWidth focused label="Location" />
            </div>

            <div
              style={{
                paddingTop: "0.5vh",
                paddingBottom: "0.5vh",
                paddingRight: "1vw",
              }}
            >
              <KeyboardDatePicker
                style={{
                  overflowY: "hidden"
                }}
                label="Check in"
                focused
                fullWidth
                format="dd/MM/yy"
                margin="none"
                // onBlur={() => onBlur(value ? new Date(value).toISOString() : null)}
                onChange={() => {
                  console.log("£h");
                }}
                value={new Date()}
              />
            </div>

            <div
              style={{
                paddingTop: "0.5vh",
                paddingBottom: "0.5vh",
                paddingRight: "1vw",
              }}
            >
              <KeyboardDatePicker
                style={{
                  overflowY: "hidden"
                }}
                label="Check out"
                focused
                fullWidth
                format="dd/MM/yy"
                margin="none"
                // onBlur={() => onBlur(value ? new Date(value).toISOString() : null)}
                onChange={() => {
                  console.log("£h");
                }}
                value={new Date()}
              />
            </div>

            <div
              style={{
                paddingTop: "0.5vh",
                paddingBottom: "0.5vh",
                paddingRight: "1vw",
              }}
            >
              <Button
                style={{
                  borderRadius: "35px",
                  width: "min-content",
                  padding: "6px",
                  marginLeft: "auto",
                  boxShadow: "none",
                  textTransform: "none",
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
    </MuiPickersUtilsProvider>
  );
};

export default SearchBar;
