import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import { Formik } from "formik";
import { Button, TextField } from "@material-ui/core";
import "./LoginForm.css";

interface FormValues {
  username: string;
  password: string;
}

interface Props extends RouteComponentProps<any> {
  onSubmit: (values: FormValues) => void;
  errors: string;
}

const LoginForm: React.FC<Props> = (props) => {
  return (
    <div
      style={{
        display: "grid",
        width: "87%",
        placeItems: "center",
        textAlign: "center",
      }}
    >
      {/* Do some Formik stuff */}
      <Formik
        onSubmit={(formValues) => {
          props.onSubmit(formValues);
        }}
        initialValues={{ username: "", password: "" }}
      >
        {({ values, handleChange }) => (
          <div>
            <TextField
              fullWidth
              value={values.username}
              variant="outlined"
              onChange={handleChange}
              type="text"
              name="username"
              label="Username"
            />
            <TextField
              fullWidth
              value={values.password}
              variant="outlined"
              onChange={handleChange}
              type="password"
              name="password"
              label="Password"
            />

            <Button
              className="continue-button"
              fullWidth
              style={{
                textTransform: "none",
              }}
              color="primary"
              variant="contained"
            >
              <span className="continue-label"><b>Continue</b></span>
            </Button>
          </div>
        )}
      </Formik>
    </div>
  );
};

export default LoginForm;
