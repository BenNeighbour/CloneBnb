import Divider from "@material-ui/core/Divider";
import Paper from "@material-ui/core/Paper";
import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import LoginForm from "./../components/Login/LoginForm";
import "./Login.css";
import Navigation from "./../components/Navigation/Navigation";

interface Props extends RouteComponentProps<any> {}

const Login: React.FC<Props> = (props) => {
  return (
    <div
      style={{
        height: "100%",
      }}
    >
      {/* Navbar Here */}
      <Navigation
        history={props.history}
        match={props.match}
        location={props.location}
      />

      <div
        style={{
          display: "grid",
          placeItems: "center",
          height: "100vh",
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

            {/* Login Form Here */}
            <LoginForm
              location={props.location}
              history={props.history}
              match={props.match}
              onSubmit={() => {}}
              errors={""}
            />
          </div>
        </Paper>
      </div>
    </div>
  );
};

export default Login;
