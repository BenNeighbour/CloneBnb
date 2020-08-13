import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import { Form, Formik } from "formik";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import "./LoginForm.css";
import FormHelperText from "@material-ui/core/FormHelperText";

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
        width: "87%",
        display: "inline-block",
        textAlign: "center",
      }}
    >
      <Formik
        onSubmit={(formValues) => {
          props.onSubmit(formValues);
        }}
        initialValues={{ username: "", password: "" }}
      >
        {({ values, handleChange }) => (
          <div
            style={{
              display: "inline-block",
              textAlign: "center",
            }}
          >
            <Form>
              <div>
                <TextField
                  style={{
                    marginBottom: "1.5vh",
                  }}
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
                <FormHelperText
                  style={{
                    color: "red",
                    paddingLeft: "5px",
                    marginTop: "0.5vh",
                    marginBottom: "1.5vh",
                  }}
                >
                  <b>{props.errors}</b>
                </FormHelperText>
              </div>

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
            </Form>
          </div>
        )}
      </Formik>
    </div>
  );
};

export default LoginForm;
