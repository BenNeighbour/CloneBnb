import Divider from "@material-ui/core/Divider";
import Paper from "@material-ui/core/Paper";
import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import LoginForm from "./../../components/Login/LoginForm";
import "./Login.css";
import Navigation from "./../../components/Navigation/Navigation";
import { USER_LOGIN } from '../../util/api/AJAX';

interface Props extends RouteComponentProps<any> {}

const Login: React.FC<Props> = (props) => {
  const [errors, setErrors] = React.useState("");

  return (
    <div
      style={{
        height: "100%",
      }}
    >
      <Navigation
        isSearchNavbar={false}
        history={props.history}
        match={props.match}
        location={props.location}
      />

      <div
        style={{
          display: "grid",
          placeItems: "center",
          height: "90vh",
        }}
      >
        <Paper
          className="loginSection"
          style={{
            width: "50%",
          }}
          variant="outlined"
        >
          <div
            style={{
              textAlign: "center",
              paddingLeft: "1vh",
              paddingRight: "1vh",
              paddingBottom: "5vh",
            }}
          >
            <h3
              style={{
                padding: "1em",
              }}
            >
              <b>Log in</b>
            </h3>

            <Divider />
            <br />
            <br />

            <LoginForm
              location={props.location}
              history={props.history}
              match={props.match}
              onSubmit={async (vals) => {
                try {
                  const response = await USER_LOGIN(vals);
              
                  if (response.status === 200) {
                    localStorage.setItem("authenticated", "true");
                    props.history.push("/home");
                  }
                } catch (err) {
                  if (err.response !== undefined && err.response.status === 401) return setErrors("Bad Credentials");
                  else return setErrors("Internal Server Error");
                }
              }}
              errors={errors}
            />
          </div>
        </Paper>
      </div>
    </div>
  );
};

export default Login;
