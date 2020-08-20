import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import { Formik } from "formik";
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
        <>
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
                overflowY: "hidden",
              }}
              value={values.checkInDate}
              label="Check in"
              focused
              fullWidth
              format="dd/MM/yy"
              margin="none"
              onChange={handleChange}
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
                overflowY: "hidden",
              }}
              value={values.checkOutDate}
              label="Check out"
              focused
              fullWidth
              format="dd/MM/yy"
              margin="none"
              onChange={handleChange}
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
              type="submit"
              color="primary"
              variant="contained"
              className="profile-button"
              fullWidth
            >
              Search
            </Button>
          </div>
        </>
      )}
    </Formik>
  );
};

export default SearchBarForm;
