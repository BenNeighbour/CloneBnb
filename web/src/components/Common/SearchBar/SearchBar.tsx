import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import { MuiPickersUtilsProvider } from "@material-ui/pickers";
import DateFnsUtils from "@date-io/date-fns";
import SearchBarForm from "./SearchBarForm";
import useTheme from "@material-ui/core/styles/useTheme";
import useMediaQuery from "@material-ui/core/useMediaQuery";
import "./SearchBar.css";
import SearchBarMobile from "./SearchBarMobile";

interface Props extends RouteComponentProps<any> {}

const SearchBar: React.FC<Props> = (props) => {
  const theme = useTheme();
  const fullScreen = useMediaQuery(theme.breakpoints.down("sm"));

  return (
    <MuiPickersUtilsProvider utils={DateFnsUtils}>
      {!fullScreen ? (
        <div
          style={{
            margin: "0 auto",
            textAlign: "center",
            display: "inline-block",
            marginTop: "10vh",
          }}
        >
          <Card className="search" variant="outlined">
            <CardContent
              style={{
                display: "flex",
                placeItems: "center",
                padding: 0,
              }}
            >
              <SearchBarForm
                errors=""
                location={props.location}
                history={props.history}
                match={props.match}
                onSubmit={(values) => {
                  // Call helper function that formats the date with the hyphens instead of slashes
                  let checkInDate: string = formatDateToLocalDate(
                    values.checkInDate
                  );
                  let checkOutDate: string = formatDateToLocalDate(
                    values.checkOutDate
                  );

                  // Redirect to search route
                  props.history.push(
                    `/search?location=${values.location}&checkIn=${checkInDate}&checkOut=${checkOutDate}`
                  );
                }}
              />
            </CardContent>
          </Card>
        </div>
      ) : (
        <SearchBarMobile
          history={props.history}
          match={props.match}
          location={props.location}
        />
      )}
    </MuiPickersUtilsProvider>
  );
};

function formatDateToLocalDate(input: Date): string {
  return input.toISOString().split("T")[0];
}

export default SearchBar;
