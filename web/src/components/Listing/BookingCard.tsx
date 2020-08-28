import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import "./MainSection.css";
import { MuiPickersUtilsProvider } from "@material-ui/pickers";
import DateFnsUtils from "@date-io/date-fns";
import BookingCardForm from "./BookingCardForm";

interface Props extends RouteComponentProps<any> {}

const BookingCard: React.FC<Props> = (props) => {
  return (
    <MuiPickersUtilsProvider utils={DateFnsUtils}>
      <div className="stickyCard">
        <Card
          className="stickyCard"
          variant="outlined"
          style={{
            border: "1px solid rgb(221, 221, 221)",
            borderRadius: "12px",
            padding: "24px",
            boxShadow: "rgba(0, 0, 0, 0.12) 0px 5px 17px",
          }}
        >
          <CardContent>
            <h2
              style={{
                fontWeight: 500,
              }}
            >
              Add Dates for pricing
            </h2>
            <br />
            <BookingCardForm
              onSubmit={(formValues) => {
                console.log(formValues)
              }}
              errors=""
              location={props.location}
              history={props.history}
              match={props.match}
            />
          </CardContent>
        </Card>
      </div>
    </MuiPickersUtilsProvider>
  );
};

export default BookingCard;
