import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import "./MainSection.css";
import Grid from "@material-ui/core/Grid";
import TextField from "@material-ui/core/TextField";
import { KeyboardDatePicker } from "@material-ui/pickers";
import { MuiPickersUtilsProvider } from "@material-ui/pickers";
import DateFnsUtils from "@date-io/date-fns";

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

            {/* Grid Here */}
            {/* Form fields Here */}
            {/* Form Submit Button Here */}
            <Grid container spacing={0}>
              <Grid item xs={12}>
                <TextField label="Guests" variant="outlined" fullWidth />
              </Grid>
              <Grid item xs={12} sm={6}>
                <KeyboardDatePicker
                  value={null}
                  inputVariant="outlined"
                  onChange={() => {}}
                  style={{
                    overflowY: "hidden",
                  }}
                  label="Check in"
                  fullWidth
                  format="dd/MM/yy"
                  margin="none"
                  name="checkInDate"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <KeyboardDatePicker
                  value={null}
                  inputVariant="outlined"
                  onChange={() => {}}
                  style={{
                    overflowY: "hidden",
                  }}
                  label="Check out"
                  fullWidth
                  format="dd/MM/yy"
                  margin="none"
                  name="checkOutDate"
                />
              </Grid>
            </Grid>
          </CardContent>
        </Card>
      </div>
    </MuiPickersUtilsProvider>
  );
};

export default BookingCard;
