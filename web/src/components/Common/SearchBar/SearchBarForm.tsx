import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import { Formik, Form, Field } from "formik";
import Button from "@material-ui/core/Button";
import { KeyboardDatePicker } from "@material-ui/pickers";
import TextField from "@material-ui/core/TextField";

interface FormValues {
  location: string;
  checkInDate: Date;
  checkOutDate: Date;
}

interface Props extends RouteComponentProps<any> {
  onSubmit: (values: FormValues) => void;
  errors: string;
}

const SearchBarForm: React.FC<Props> = (props) => {
  return (
    <Formik
      onSubmit={(formValues) => {
        props.onSubmit(formValues);
      }}
      initialValues={{
        location: "",
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
          <div
            style={{
              paddingTop: "0.5vh",
              paddingBottom: "0.5vh",
              flex: "1 0 0",
              paddingRight: "1vw",
              paddingLeft: "2vw",
            }}
          >
            <TextField
              value={values.location}
              onChange={handleChange}
              fullWidth
              focused
              label="Location"
              name="location"
            />
          </div>
          <div
            style={{
              paddingTop: "0.5vh",
              paddingBottom: "0.5vh",
              paddingRight: "1vw",
            }}
          >
            <Field name="checkInDate" label="Check-in" component={DatePickerField} />
          </div>

          <div
            style={{
              paddingTop: "0.5vh",
              paddingBottom: "0.5vh",
              paddingRight: "1vw",
            }}
          >
            <Field name="checkOutDate" label="Check-out" component={DatePickerField} />
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
              type="submit"
              color="primary"
              variant="contained"
              className="profile-button"
              fullWidth
            >
              Search
            </Button>
          </div>
        </Form>
      )}
    </Formik>
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

export default SearchBarForm;
