import { AppBar, Divider, Paper } from "@material-ui/core";
import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import LoginForm from "./../components/Login/LoginForm";
import "./Login.css"

interface Props extends RouteComponentProps<any> {}

const Login: React.FC<Props> = (props) => {
  return (
    <div
      style={{
        height: "100%",
      }}
    >
      {/* Navbar Here */}
      <AppBar
        style={{
          backgroundColor: "white",
          marginBottom: "1vh",
        }}
      >
        <div
          style={{
            paddingLeft: "80px",
            paddingRight: "80px",
            minHeight: "8vh",
          }}
        >
          <div
            style={{
              lineHeight: 1,
              height: "100%",
              paddingTop: "2.66vh",
              paddingBottom: "2.66vh",
            }}
          >
            <h3
              style={{
                color: "#FF385C",
                fontSize: "150%",
                padding: 0,
              }}
            >
              <b>CloneBnb</b>
            </h3>
          </div>
        </div>
      </AppBar>

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
            width: "50%" 
          }}
          variant="outlined"
        >
          <div
            style={{
              textAlign: "center",
              paddingLeft: "1vh",
              paddingRight: "1vh",
              paddingBottom: "5vh"
            }}
          >
            <h3 style={{
              padding: "1em"
            }}>
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
