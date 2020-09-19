import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Grid from "@material-ui/core/Grid";
import { KeyboardDatePicker } from "@material-ui/pickers";
import { Formik } from "formik";
import { Form } from "formik";
import Button from "@material-ui/core/Button";

interface FormValues {
  checkInDate: Date;
  checkOutDate: Date;
}

interface Props extends RouteComponentProps<any> {
  onSubmit: (values: FormValues) => void;
  errors: string;
}

const BookingCardForm: React.FC<Props> = (props) => {
  return (
    <Grid container spacing={0}>
      <Formik
        onSubmit={(formValues) => {
          props.onSubmit(formValues);
        }}
        initialValues={{
          checkInDate: new Date(),
          checkOutDate: new Date(),
        }}
      >
        {({ values, handleChange }) => (
          <Form
            style={{
              display: "contents",
            }}
          >
            <Grid item xs={12} sm={6}>
              <KeyboardDatePicker
                value={values.checkInDate}
                onChange={handleChange}
                inputVariant="outlined"
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
                value={values.checkOutDate}
                inputVariant="outlined"
                onChange={handleChange}
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
            <Grid
              item
              xs={12}
              style={{
                paddingTop: "1.5vh",
              }}
            >
              <Button
                className="continue-button"
                fullWidth
                style={{
                  textTransform: "none",
                }}
                color="primary"
                variant="contained"
                type="submit"
              >
                <span className="continue-label">
                  <b>Continue</b>
                </span>
              </Button>
            </Grid>
          </Form>
        )}
      </Formik>
    </Grid>
  );
};

export default BookingCardForm;
