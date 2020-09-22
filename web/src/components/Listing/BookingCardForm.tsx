import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Grid from "@material-ui/core/Grid";
import { KeyboardDatePicker } from "@material-ui/pickers";
import { Formik, Form, Field } from "formik";
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
              <Field name="checkInDate" label="Check-in " component={DatePickerField} />
            </Grid>
            <Grid item xs={12} sm={6}>
              <Field name="checkOutDate" label="Check-out" component={DatePickerField} />
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

const DatePickerField = ({ field, form, ...other }) => {
  const currentError = form.errors[field.name];

  return (
    <KeyboardDatePicker
      style={{
        overflowY: "hidden",
      }}
      disablePast
      name={field.name}
      value={field.value}
      format="dd/MM/yyyy"
      focused
      fullWidth
      helperText={currentError}
      error={Boolean(currentError)}
      onError={(error) => {
        if (error !== currentError) {
          form.setFieldError(field.name, error);
        }
      }}
      onChange={(date) => form.setFieldValue(field.name, date, false)}
      {...other}
    />
  );
};

export default BookingCardForm;
